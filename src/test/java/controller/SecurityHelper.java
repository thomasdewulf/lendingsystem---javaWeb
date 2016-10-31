/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Maarten
 */
public class SecurityHelper
{

    public static void setupSecurityContext(String username, String password, String... groups)
    {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String group : groups)
        {
            authorities.add(new SimpleGrantedAuthority(group));
        }

        UserDetails user = new User(username, password, authorities);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, password);
        SecurityContextHolder.getContext().setAuthentication(token);
    }
}
