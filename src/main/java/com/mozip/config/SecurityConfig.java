package com.mozip.config;

import com.mozip.config.auth.PrincipalOauth2UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.
                authorizeHttpRequests(auth -> auth.requestMatchers("/auth/login", "/auth/join", "/", "/project/show", "/member/**",
                                                                "/api/**", "/project", "/project/**", "/css/**", "/js/**", "/img/**", "/upload/**").permitAll().
                                                requestMatchers("/member/edit/**", "/project/create", "/member/projectList/**").authenticated().
                                                anyRequest().authenticated())
                .csrf(config -> config.disable())
                .formLogin(config -> config.
                        loginPage("/auth/login").
                        usernameParameter("email").
                        passwordParameter("password").
                        successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                                log.info("authentication : {}", authentication.getName()); // 인증에 성공한 사용자 이름 출력
                                response.sendRedirect("/"); // 루트 페이지로 이동
                            }
                        }).
                        failureHandler(new AuthenticationFailureHandler() {
                            @Override
                            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                                log.error("authentication : {}", exception.getMessage());
                                String errorMessage = URLEncoder.encode(exception.getMessage(), StandardCharsets.UTF_8.toString());
                                response.sendRedirect("/auth/login?error=true&message=" + errorMessage);
                            }
                        })
                        .permitAll()
                )
                .logout(config -> config.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout")).logoutSuccessUrl("/").invalidateHttpSession(true))
                .oauth2Login(oauth -> oauth.userInfoEndpoint(c -> c.userService(principalOauth2UserService)).defaultSuccessUrl("/", true));

        return http.build();
    }
}
