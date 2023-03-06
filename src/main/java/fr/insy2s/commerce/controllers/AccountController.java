package fr.insy2s.commerce.controllers;

import fr.insy2s.commerce.dtos.AccountDto;
import fr.insy2s.commerce.dtos.RoleDto;
import fr.insy2s.commerce.models.Account;
//import fr.insy2s.commerce.security.filter.CustomAuthorizationFilter;
import fr.insy2s.commerce.services.IAccountService;
import fr.insy2s.commerce.services.impl.AccountServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/account")
public class AccountController {
    private final IAccountService accountService;
    /*private final AccountServiceImpl accountService;*/
//    private final CustomAuthorizationFilter customAuthorizationFilter;

    /* Get all with archive */
    @GetMapping("/allAll")
    public List<AccountDto> getAll() {
        return accountService.getAll();
    }

    /* Get all without Archive */
    @GetMapping("/all")
    public List<AccountDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    /*Get all Archive */
    @GetMapping("/archive")
    public List<AccountDto> getAllArchive() {
        return accountService.getAllArchive();
    }

    @GetMapping("/detail/{id}")
    public AccountDto user(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @PostMapping("/add")
    public Account addAccount(@Validated @RequestBody Account account) {

        return accountService.addAccount(account);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }


//    @GetMapping("/token/refresh")
//    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        customAuthorizationFilter.refreshToken(request,response);  }

    @PutMapping("/update")
    public AccountDto updateAccount(@RequestBody AccountDto accountDetails) {
        //System.out.println(accountDetails);
        return accountService.updateAccount(accountDetails);
    }


}
