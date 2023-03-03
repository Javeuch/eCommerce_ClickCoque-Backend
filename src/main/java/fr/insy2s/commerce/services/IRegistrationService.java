package fr.insy2s.commerce.services;

import fr.insy2s.commerce.dtos.AccountDto;


public interface IRegistrationService {
    String register(AccountDto accountDto);

    String confirmToken(String token);
}
