package com.example.GroupFitness.controller;

import com.example.GroupFitness.registration.RegistrationRequest;
import com.example.GroupFitness.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ModelAndView createRequest(@ModelAttribute RegistrationRequest registrationRequest) {
        registrationService.register(registrationRequest);
        ModelAndView mav = new ModelAndView("emailSent");
        return mav;
    }

    @GetMapping(path = "confirm")
    public ModelAndView confirm(@RequestParam("token") String token) {
        registrationService.confirmToken(token);
        ModelAndView mav = new ModelAndView("registrationSuccess");
        return mav;
    }
}
