package com.jobportal.job_portal_app.config;

import com.jobportal.job_portal_app.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    private final CustomUserDetailsService customUserdetailsService;
    private final CustomauthenticationSuccessHandler customauthenticationSuccessHandler;
    private final String[] publicUrl = {"/",
            "/global-search/**",
            "/register",
            "/register/**",
            "/webjars/**",
            "/resources/**",
            "/assets/**",
            "/css/**",
            "/summernote/**",
            "/js/**",
            "/*.css",
            "/*.js",
            "/*.js.map",
            "/fonts**", "/favicon.ico", "/resources/**", "/error"
    };

    @Autowired
    public WebSecurityConfig(CustomUserDetailsService customUserdetailsService,
                             CustomauthenticationSuccessHandler customauthenticationSuccessHandler) {
        this.customUserdetailsService = customUserdetailsService;
        this.customauthenticationSuccessHandler = customauthenticationSuccessHandler;
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authenticationProvider(authenticationProvided());
        http.authorizeHttpRequests(auth -> {
            //any one can access this url at this line
            auth.requestMatchers(publicUrl).permitAll();
            //you must be authenticated to make a request
            auth.anyRequest().authenticated();
        });

        http.formLogin(form->form.loginPage("/login").permitAll()
                        .successHandler(customauthenticationSuccessHandler))
                .logout(logout->{
                    logout.logoutUrl("/logout");
                    logout.logoutSuccessUrl("/");
                }).cors(Customizer.withDefaults()).csrf(csrf->csrf.disable());
        return http.build();
    }

    //tel Spring security how to find our users and how to authenticate passwords
    @Bean
    public AuthenticationProvider authenticationProvided() {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        //tell spring security how to retrieve the users from the database
        authenticationProvider.setUserDetailsService(customUserdetailsService);
        return authenticationProvider;
    }

    //Tell spring security how to authenticate passwords(plain text or encryption)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
