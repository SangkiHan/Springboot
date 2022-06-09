package com.mcnc.practice.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mcnc.practice.demo.Exception.WebAccessDeniedHandler;
import com.mcnc.practice.demo.Security.CustomAuthenticateProvider;
import com.mcnc.practice.demo.Security.CustomAuthenticationFilter;
import com.mcnc.practice.demo.user.Service.userServiceimpl;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity        //spring security 를 적용한다는 Annotation
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private userServiceimpl userServiceimpl;
	
	@Autowired
	private WebAccessDeniedHandler webAccessDeniedHandler;
	

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.addFilterAfter(customAuthenticationFilter(), CsrfFilter.class)
            .authorizeRequests()
                .antMatchers( "/login", "/singUp", "/access_denied", "/resources/**").permitAll()
                .antMatchers("/").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
            	.logoutUrl("/logout")
            	.logoutSuccessUrl("/login")
            	.permitAll()
            	.and()
            .exceptionHandling()
            	.accessDeniedPage("/err/denied-page")
            	.and()
            .csrf().disable();		
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(AuthenticationProvider());
    }
    
    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter(
                new AntPathRequestMatcher("/login", HttpMethod.POST.name())
        );
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler("/user_access"));
        filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/access_denied"));
        return filter;
    }

    @Bean
	public AuthenticationProvider AuthenticationProvider() {
		// TODO Auto-generated method stub
		return new CustomAuthenticateProvider(userServiceimpl);
	}
	
	@Bean
    @Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
    public PasswordEncoder getPasswordEncoder() {
       return new BCryptPasswordEncoder();
    }
}
