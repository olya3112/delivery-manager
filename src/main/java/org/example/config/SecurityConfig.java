package org.example.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {



    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.httpFirewall(defaultHttpFirewall()).
               ignoring().requestMatchers(
                "/swagger-ui.html",
                "/*",
                "/opportunity/*",
                "/manager/users",
                "/swagger-ui/**",
                "/v3/api-docs/**"
               );
    }


    @Bean
    public HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }


}
