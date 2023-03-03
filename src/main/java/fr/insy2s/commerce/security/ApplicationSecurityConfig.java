package fr.insy2s.commerce.security;


import fr.insy2s.commerce.security.filter.CustomAuthenticationFilter;
import fr.insy2s.commerce.security.filter.CustomAuthorizationFilter;
import fr.insy2s.commerce.services.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserDetailsService userDetailsService;




    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


                CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
                customAuthenticationFilter.setFilterProcessesUrl("api/login");
                http.csrf().disable(); //TODO : is coming
                http.sessionManagement().sessionCreationPolicy(STATELESS);
                http.authorizeRequests().antMatchers("api/login/**","api/token/refresh/**","http://localhost:3000","api/product").permitAll();
                http.authorizeRequests().antMatchers(GET, "api/account/**").hasAnyAuthority("admin");
                http.authorizeRequests().antMatchers(POST, "api/account/add").hasAnyAuthority("admin");
                http.addFilter(customAuthenticationFilter);
                http.authorizeRequests().anyRequest().authenticated();
                http.addFilterBefore(new CustomAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
                http.logout()
                        .logoutUrl("/logout")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .deleteCookies("access_token","refresh_token")
                        .logoutSuccessUrl("/login");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }






}
