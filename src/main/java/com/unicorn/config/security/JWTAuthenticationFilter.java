package com.unicorn.config.security;

import static java.util.Collections.emptyList;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.unicorn.entity.User;
import com.unicorn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@Component
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String authorization = servletRequest.getHeader("Authorization");
        String username = authorization.substring(0, authorization.indexOf("."));
        User user = userRepository.findByUsername(username);
//        if(user != null) {
//            String password = authorization.substring(authorization.indexOf(".") + 1);
//            if(passwordEncoder.encode(password).equals(user.getPassword())) {
//                Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, emptyList());
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
        filterChain.doFilter(request, response);
    }
}