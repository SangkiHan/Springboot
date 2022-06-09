package com.mcnc.practice.demo.Security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.mcnc.practice.demo.user.domain.UserVo;

@SuppressWarnings("serial")
public class CustomAuthenticationToken extends AbstractAuthenticationToken {
	
    private String email;
    private String credentials;
    private Object principal;

    public CustomAuthenticationToken(Object principal, String credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.email = email;
        this.credentials = credentials;
        this.principal = principal;
    }


	public CustomAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
    	
        return this.principal;
    }
}
