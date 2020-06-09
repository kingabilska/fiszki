package com.kibi.fiszki.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDetailsManager userDetailsManager;

    public void registerUser(String login, String password) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        userDetailsManager.createUser(new User(login, password, authorities));
    }

    public void authUser(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            //do nothing
        }
    }

    public void registerAndAuthUser(HttpServletRequest request, String username, String password) {
        registerUser(username, password);
        authUser(request, username, password);
    }
}
