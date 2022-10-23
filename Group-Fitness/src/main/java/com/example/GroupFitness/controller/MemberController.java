package com.example.GroupFitness.controller;
import com.example.GroupFitness.entity.AuthMember;
import com.example.GroupFitness.repository.AuthMemberRepository;
import com.example.GroupFitness.repository.ConfirmationTokenRepository;
import com.example.GroupFitness.repository.GoalRepository;
import com.example.GroupFitness.service.AuthMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberController {
    @Autowired
    private GoalRepository gRepo;
    @Autowired
    private AuthMemberRepository amRepo;
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

    @GetMapping({"/homepage", "/"})
    public ModelAndView showHomepage() {
        ModelAndView mav = new ModelAndView(("homepage"));
        AuthMember member = amRepo.findById(getCurrentUser().getId()).get();
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
}
