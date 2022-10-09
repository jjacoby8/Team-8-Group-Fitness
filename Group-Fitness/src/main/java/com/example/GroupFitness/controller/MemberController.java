package com.example.GroupFitness.controller;

import com.example.GroupFitness.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository mRepo;

    @GetMapping({"/showMembers", "/", "list"})
    public ModelAndView showMembers() {
        ModelAndView mav = new ModelAndView("list-members");
        mav.addObject("members", mRepo.findAll());
        return mav;
    }
}
