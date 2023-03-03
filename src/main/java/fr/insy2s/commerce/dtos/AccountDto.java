package fr.insy2s.commerce.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDto implements UserDetails {

    private String firstName;

    private String lastName;

    private String username;

    private LocalDate birthDate;

    private String phoneNumber;

    private String email;

    @JsonIgnoreProperties("users")
    private RoleDto role;

    private String password;

    @JsonIgnoreProperties("users")
    private AddressDto address;






    @JsonIgnoreProperties("user")
    private List<CommandDto> commands;

    @JsonIgnoreProperties("user")
    private List<NoteDto> notes;

    private boolean softDelete ;


    private boolean locked;

    private boolean enabled;

    private List<GrantedAuthority> authorities;


    public AccountDto(String firstName, String lastName, String email, String password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
    }

    public AccountDto(AccountDto accountDto){
        this.firstName= accountDto.getFirstName();
        this.lastName=accountDto.getLastName();
        this.birthDate=accountDto.getBirthDate();
        this.username= accountDto.getUsername();       
        this.email=accountDto.getEmail();
        this.password= accountDto.getPassword();
        
        /*this.authorities=accountDto.getRoles().stream().map(roles -> new SimpleGrantedAuthority(roles.getLabel())).collect(Collectors.toList());*/
    }


    public AccountDto(String firstName, String lastName, LocalDate birthDate, String phoneNumber, String email, String password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.birthDate=birthDate;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.password=password;
    }




    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }*/



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        RoleDto role = getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getLabel()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return enabled;
    }


    public AccountDto(String firstName, String lastName, AddressDto address, LocalDate birthDate, String phoneNumber, String email, String password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.birthDate=birthDate;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.password=password;
    }



}
