package com.example.GroupFitness.controller;

import com.example.GroupFitness.entity.AuthMember;
import com.example.GroupFitness.entity.Goal;
import com.example.GroupFitness.entity.Progress;
import com.example.GroupFitness.repository.AuthMemberRepository;
import com.example.GroupFitness.repository.GoalRepository;
import com.example.GroupFitness.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class GoalController {
    @Autowired
    private AuthMemberRepository amRepo;
    @Autowired
    private GoalRepository gRepo;
    @Autowired
    private ProgressRepository pRepo;

    public AuthMember getCurrentUser() {
        AuthMember authMember = (AuthMember) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return amRepo.findById(authMember.getId()).get();
    }

    @GetMapping("/addGoalForm")
    public ModelAndView addGoalForm() {
        ModelAndView mav = new ModelAndView("add-goal-form.html");
        Goal goal = new Goal();
        goal.setMemberId(getCurrentUser().getId());
        mav.addObject("goal", goal);
        return mav;
    }

    @PostMapping("/saveGoal")
    public String saveGoal(@ModelAttribute Goal goal) {
        gRepo.save(goal);
        return "redirect:/profile";
    }

    @GetMapping("/showGoalUpdateForm")
    public ModelAndView showGoalUpdateForm(@RequestParam Long goalId) {
        ModelAndView mav = new ModelAndView("add-goal-form.html");
        Goal goal = gRepo.findById(goalId).get();
        mav.addObject("goal", goal);
        return mav;
    }

    @GetMapping("/deleteGoal")
    public String deleteGoal(@RequestParam Long goalId) {
        gRepo.deleteById(goalId);
        return "redirect:/profile";
    }

    @GetMapping("/addProgress")
    public ModelAndView addProgress(@RequestParam Long goalId) {
        ModelAndView mav = new ModelAndView("add-progress-form.html");
        Goal goal = gRepo.findById(goalId).get();

        Progress progress = new Progress();
        progress.setGoalId(goalId);
        progress.setMemberId(goal.getMemberId());
        mav.addObject("progress", progress);
        return mav;
    }

    @PostMapping("/saveProgress")
    public String saveProgress (@ModelAttribute Progress progress) {
        progress.setDateOfUpdate(DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDateTime.now()));
        pRepo.save(progress);

        // Update the parent goal's current progress
        Goal goal = gRepo.findById(progress.getGoalId()).get();
        goal.setProgress(progress.getNewValue());
        gRepo.save(goal);

        return "redirect:/profile";
    }
}
