package com.rungroup.web.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.swing.plaf.nimbus.State;

public class SecurityUtil {
    public static  String getSessionUSer(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername=authentication.getName();
            return  currentUsername;
        }
        return  null;
    }
}
