package com.example.GroupFitness.controller;
import com.example.GroupFitness.entity.*;
import com.example.GroupFitness.registration.RegistrationRequest;
import com.example.GroupFitness.repository.*;
import com.example.GroupFitness.service.AuthMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MemberController {
    @Autowired
    private GoalRepository gRepo;
    @Autowired
    private AuthMemberRepository amRepo;
    @Autowired
    private FriendRepository fRepo;
    @Autowired
    private ProgressRepository pRepo;
    @Autowired
    private FeedNotificationRepository nRepo;
    @Autowired
    private ConfirmationTokenRepository cRepo;
    private final AuthMemberService authMemberService;

    public MemberController(AuthMemberService authMemberService) {
        this.authMemberService = authMemberService;
    }

    @RequestMapping(value = "/userId", method = RequestMethod.GET)
    @ResponseBody
    public AuthMember getCurrentUser() {
        AuthMember authMember = (AuthMember) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return amRepo.findById(authMember.getId()).get();
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Your email and password are invalid.");
        if (logout != null)
            model.addAttribute("msg", "You have been successfully logged out.");
        return "login";
    }

    @GetMapping({"/homepage", "/"})
    public ModelAndView showHomepage() {
        ModelAndView mav = new ModelAndView(("homepage"));
        AuthMember member = amRepo.findById(getCurrentUser().getId()).get();

        // Get friends
        List<Friend> friendRequests = fRepo.getFriendsOfMember(getCurrentUser().getId());
        List<AuthMember> friendUsers = new ArrayList<>();
        for(Friend friend : friendRequests) {
            if (!friend.isAcceptedRequest()) continue;

            // Get the user info for the other user
            if (getCurrentUser().getId().equals(friend.getFirstMemberId())) {
                AuthMember curMember = amRepo.findById(friend.getSecondMemberId()).get();
                friendUsers.add(curMember);
            }
            else if (getCurrentUser().getId().equals(friend.getSecondMemberId())) {
                AuthMember curMember = amRepo.findById(friend.getFirstMemberId()).get();
                friendUsers.add(curMember);
            }

        }

        List<FeedNotification> notifications = new ArrayList<>();

        for (AuthMember friend : friendUsers) {
            notifications.addAll(nRepo.findNotificationsByMemberId(friend.getId()));
        }
        notifications.addAll(nRepo.findNotificationsByMemberId(getCurrentUser().getId()));

        List<Goal> memberGoals = gRepo.findGoalsByMemberId(getCurrentUser().getId());

        mav.addObject("goals", memberGoals);
        mav.addObject("friends", friendUsers);
        mav.addObject("allProgress", notifications);
        mav.addObject("member", member);
        return mav;
    }

    @GetMapping({"/memberProfile", "/profile"})
    public ModelAndView showUserProfile() {
        ModelAndView mav = new ModelAndView("member-profile");
        AuthMember authMember = getCurrentUser();
        mav.addObject("member", authMember);
        mav.addObject("goals", gRepo.findGoalsByMemberId(authMember.getId()));
        return mav;
    }

    @GetMapping("/showMemberUpdateForm")
    public ModelAndView showMemberUpdateForm() {
        ModelAndView mav = new ModelAndView("profile-settings");
        AuthMember authMember = getCurrentUser();
        mav.addObject("member", authMember);
        return mav;
    }

    @PostMapping("/saveMember")
    public String saveMember(@ModelAttribute AuthMember member) {
        amRepo.save(member);
        return "redirect:/profile";
    }

    @GetMapping({"/admins"})
    public ModelAndView showAdmins() {
        ModelAndView mav = new ModelAndView("admin-panel");
        mav.addObject("members", amRepo.findAll());
        return mav;
    }
    //
    @GetMapping("/addMembers")
    public ModelAndView addMembers() {
        ModelAndView mav = new ModelAndView("add-members");
        AuthMember member = new AuthMember();
        mav.addObject("member", member);
        return mav;
    }

    @PostMapping("/saveMemberAdmin")
    public String saveMemberAdmin(@ModelAttribute AuthMember member) {
        if (amRepo.findByEmail(member.getEmail()).isEmpty()) {
            authMemberService.signUpMember(member);
        }
        else {
            amRepo.save(member);
        }

        return "redirect:/admins";
    }

    @GetMapping("/updateMember")
    public ModelAndView updateMember(@RequestParam Long memberId) {
        ModelAndView mav = new ModelAndView("add-members");
        AuthMember member = amRepo.findById(memberId).get();
        mav.addObject("member", member);
        return mav;
    }

    @GetMapping("/deleteMember")
    public String deleteMember(@RequestParam Long memberId) {
        cRepo.deleteByMemberId(memberId);
        amRepo.deleteById(memberId);
        return "redirect:/admins";
    }

    @GetMapping("/registerUser")
    public ModelAndView registerUser() {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("registrationRequest", new RegistrationRequest("","","",""));
        return mav;
    }

    @GetMapping("/createFriendRequest")
    public ModelAndView createFriendRequest() {
        Friend newFriendRequest = new Friend();
        newFriendRequest.setFirstMemberId(getCurrentUser().getId());
        newFriendRequest.setAcceptedRequest(false);
        ModelAndView mav = new ModelAndView("createFriendRequest");
        mav.addObject("friend", newFriendRequest);
        return mav;
    }

    @PostMapping("/sendFriendRequest")
    public String sendFriendRequest(@ModelAttribute Friend friend) {
        if (amRepo.findById(friend.getSecondMemberId()).isPresent()
                && !fRepo.exists(Example.of(friend))) {
            fRepo.save(friend);
        }

        return "redirect:/homepage";
    }

    @GetMapping("/viewFriendRequests")
    public ModelAndView viewFriendRequests() {
        ModelAndView mav = new ModelAndView("viewFriendRequests");
        List<Friend> friendRequests = fRepo.getIncomingFriendRequestsForMember(getCurrentUser().getId());
        List<AuthMember> associatedUsers = new ArrayList<>();
        for(Friend friend : friendRequests) {
           AuthMember curMember = amRepo.findById(friend.getFirstMemberId()).get();
           associatedUsers.add(curMember);
        }
        mav.addObject("potentialFriends", associatedUsers);
        return mav;
    }

    @GetMapping("/acceptFriendRequest")
    public String acceptFriendRequest(@RequestParam Long friendMemberId) {
        Friend request = fRepo.getRequestByFriendId(friendMemberId, getCurrentUser().getId());
        request.setAcceptedRequest(true);
        fRepo.save(request);
        return "redirect:/viewFriendRequests";
    }

    @GetMapping("/declineFriendRequest")
    public String declineFriendRequest(@RequestParam Long friendMemberId) {
        Friend request = fRepo.getRequestByFriendId(getCurrentUser().getId(), friendMemberId);
        fRepo.deleteById(request.getId());
        return "redirect:/viewFriendRequests";
    }
}
