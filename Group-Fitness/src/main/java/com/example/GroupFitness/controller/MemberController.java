package com.example.GroupFitness.controller;
import com.example.GroupFitness.entity.Member;
import com.example.GroupFitness.repository.GoalRepository;
import com.example.GroupFitness.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository mRepo;
    @Autowired
    private GoalRepository gRepo;

    @GetMapping({"/homepage", "/"})
    public ModelAndView showHomepage(@RequestParam Long memberId) {
        ModelAndView mav = new ModelAndView(("homepage"));
        Member member = mRepo.findById(memberId).get();
        mav.addObject("member", member);
        return mav;
    }

    @GetMapping({"/memberProfile", "/profile"})
    public ModelAndView showUserProfile(@RequestParam Long memberId) {
        ModelAndView mav = new ModelAndView("member-profile");
        Member member = mRepo.findById(memberId).get();
        mav.addObject("member", member);
        mav.addObject("goals", gRepo.findGoalsByMemberId(memberId));
        return mav;
    }

    @GetMapping("/showMemberUpdateForm")
    public ModelAndView showMemberUpdateForm(@RequestParam Long memberId) {
        ModelAndView mav = new ModelAndView("update-member-form.html");
        Member member = mRepo.findById(memberId).get();
        mav.addObject("member", member);
        return mav;
    }

    @PostMapping("/saveMember")
    public String saveMember(@ModelAttribute Member member) {
        mRepo.save(member);
        return "redirect:/profile";
    }
}
