package com.example.GroupFitness.controller;
import com.example.GroupFitness.entity.Goal;
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

    @GetMapping({"/memberProfile", "/", "/profile"})
    public ModelAndView showUserProfile() {
        ModelAndView mav = new ModelAndView("member-profile");
        Member testMember = new Member();
        testMember.setId(1L);
        testMember.setName("Joshua Jacoby");
        testMember.setEmail("jjacoby@fake.com");
        testMember.setAdmin(true);
        mav.addObject("member", testMember);
        mav.addObject("goals", gRepo.findAll());
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
