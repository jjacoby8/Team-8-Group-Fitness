package com.example.GroupFitness.controller;

import com.example.GroupFitness.registration.RegistrationRequest;
import com.example.GroupFitness.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String createRequest(@ModelAttribute RegistrationRequest registrationRequest) {
        return registrationService.register(registrationRequest);
    }

    //@PostMapping
    //public String register(@RequestBody RegistrationRequest request) {
    //    return registrationService.register(request);
    //}

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
