package fr.insy2s.commerce.controllers;

import fr.insy2s.commerce.dtos.AccountDto;

import fr.insy2s.commerce.services.IRegistrationService;
import fr.insy2s.commerce.services.impl.RegistrationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationServiceImpl registrationService;

    @PostMapping
    public String register(@RequestBody AccountDto accountDto) {

        return registrationService.register(accountDto);
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {

        return registrationService.confirmToken(token);
    }
}
