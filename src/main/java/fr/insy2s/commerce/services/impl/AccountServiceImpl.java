package fr.insy2s.commerce.services.impl;

import com.auth0.jwt.JWT;
import fr.insy2s.commerce.dtos.AccountDto;

import fr.insy2s.commerce.models.Account;
import fr.insy2s.commerce.repositories.IAccountRepository;
import fr.insy2s.commerce.services.IAccountService;
import fr.insy2s.commerce.models.ConfirmationToken;
import fr.insy2s.commerce.services.IConfirmationTokenService;
import fr.insy2s.commerce.services.IRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService,UserDetailsService {



    private final IAccountRepository accountRepository;
    private final IRoleService roleService;
    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final IConfirmationTokenService confirmationTokenService;



    @Override
    public AccountDto findById(Long id) {
        Account account = accountRepository.findById(id).orElse(null);
        return modelMapper.map(account, AccountDto.class);
    }
    @Override
    public AccountDto getAccount(String username){
        Account account = accountRepository.findByUsername(username);
        return modelMapper.map(account, AccountDto.class);
    }

    /* Get All account (with archives)*/
    @Override
    public List<AccountDto> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }

    /* Get All account (without archives)*/
    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAllWithoutArchive()
                .stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }

    /* Get All Archives */
    @Override
    public List<AccountDto> getAllArchive() {
        return accountRepository.findAllArchive()
                .stream()
                .map(account -> modelMapper.map(account, AccountDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Account addAccount(Account account) {

        return accountRepository.save(account);
    }


    public String registerAccount(AccountDto accountDto) {
        boolean accountAlreadyExists = accountRepository
                .findByEmail(accountDto.getEmail())
                .isPresent();
        if (accountAlreadyExists) {
            // TODO check of attributes are the same

            throw new IllegalStateException("email already exists");
        }
        Account account = modelMapper.map(accountDto,Account.class);
        account.setPassword(passwordEncoder.encode(account.getPassword()));




        accountRepository.save(account);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(

                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                account
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

        return token;

    }
    @Override
    public int enableAccount(String email) {
        return accountRepository.enableAccount(email);
    }


    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if(account == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else {
            log.info("User found in the database: {}",username);

        }
        Collection<SimpleGrantedAuthority>authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.getRole().getLabel()));
        return new org.springframework.security.core.userdetails.User(account.getUsername(),account.getPassword(),authorities);
    }
    @Override
    public AccountDto updateAccount(AccountDto accountDto){
        //System.out.println(accountDto);
        Optional<Account> account = accountRepository.findByEmail(accountDto.getEmail());
        if (account.isPresent()){
            account.get().setFirstName(accountDto.getFirstName());
            account.get().setLastName(accountDto.getLastName());
            account.get().getAddress().setNumber(accountDto.getAddress().getNumber());
            account.get().getAddress().setStreet(accountDto.getAddress().getStreet());
            account.get().getAddress().setZipcode(accountDto.getAddress().getZipcode());
            account.get().getAddress().setCity(accountDto.getAddress().getCity());
            account.get().getAddress().setCountry(accountDto.getAddress().getCountry());

            account.get().setBirthDate(accountDto.getBirthDate());
            account.get().setPhoneNumber(accountDto.getPhoneNumber());
            account.get().setEmail(accountDto.getEmail());
            return modelMapper.map(accountRepository.save(account.get()), AccountDto.class);
        }
        return accountDto;
    }

}
