package com.mcnc.practice.demo.Exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.mcnc.practice.demo.user.domain.UserVo;


@Component
public class WebAccessDeniedHandler implements AccessDeniedHandler{
	

	private static final Logger logger = LoggerFactory.getLogger(WebAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		response.setStatus(HttpStatus.FORBIDDEN.value());
		
		
		request.getRequestDispatcher("/err/denied-page").forward(request, response);
		
	}

}
