package fr.insy2s.commerce.services;

import fr.insy2s.commerce.dtos.AccountDto;

import fr.insy2s.commerce.models.Account;

import java.util.List;

public interface IAccountService {

    AccountDto findById(Long id);

    AccountDto getAccount(String username);

    List<AccountDto> getAll();

    List<AccountDto> getAllAccounts();

    List<AccountDto> getAllArchive();

    Account addAccount(Account account);


    int enableAccount(String email);

    void deleteAccount(Long id);


    String registerAccount(AccountDto accountDto);

    AccountDto updateAccount(AccountDto accountDetail);



}
