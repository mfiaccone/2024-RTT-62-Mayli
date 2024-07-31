package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SpringSecurity {

    @Bean(name="passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // boiler plate code to protect a common hack
        http.csrf(csrf -> csrf.disable());

        // this section says allow all pages EXCEPT the ones that are in the AntPthRequestMatcher
        // anything in AntPathRequestMatcher will require the user to be authenticated
        http.authorizeRequests()
                .requestMatchers(
                        new AntPathRequestMatcher("/admin/**"),
                        new AntPathRequestMatcher("/employee/**")).authenticated()
                .anyRequest().permitAll();

        // the loginPage parameter is the actual URL of the login page
        // the loginProcessingUrl is the URL that the form will submit to
        http.formLogin(formLogin -> formLogin
                // this is a controller method URL for displaying the login page (this can be any url but has to match JSP form action)
                // we built this controller method, however this is just the URL in the browser for the login page
                .loginPage("/account/loginPageUrl")


                // this Url is part of spring security and we do not need to implement it in our controller
                // we just need to make the form action submit to this URL
                .loginProcessingUrl("/account/loginProcessingURL"));
                // so 3 things need to be done on the login.jsp
                // 1) action needs to be set to /account/loginProcessingURL
                // 2) input field for username needs to be named "username"
                // 3) input field for password needs to be named "password"

        // this is the URL that will log a user out
                http.logout(formLogout -> formLogout
                        .invalidateHttpSession(true)
                        // this is the URL that will log a user out
                        .logoutUrl("/login/logout")
                        .logoutSuccessUrl("/"));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }


}
