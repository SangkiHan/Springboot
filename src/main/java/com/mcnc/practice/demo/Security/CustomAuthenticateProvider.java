package com.mcnc.practice.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.mcnc.practice.demo.user.Service.userServiceimpl;

public class CustomAuthenticateProvider implements AuthenticationProvider{
	
	private userServiceimpl userServiceimpl;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	public CustomAuthenticateProvider(userServiceimpl userServiceimpl) {
		// TODO Auto-generated constructor stub
		this.userServiceimpl = userServiceimpl;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		UserDetails user = userServiceimpl.loadUserByUsername(username);
		if(user == null) {
			throw new BadCredentialsException("username is not found. username = "+username);
			
		}
		
		if (!this.passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("password is not matched");
        }

        return new CustomAuthenticationToken(user, password, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return CustomAuthenticationToken.class.isAssignableFrom(authentication);
	}

	

	
}
