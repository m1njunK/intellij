package com.bitc.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.bitc.sec.security.CustomAccessDeniedHandler;
import com.bitc.sec.security.LoginSuccessHandler;
import com.bitc.sec.security.user.CustomUserDetailsService;

@Configuration
// Security Filter Chain 추가
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public WebSecurityCustomizer webCustomizer() {
		// return (web) -> web.ignoring().antMatchers("/resources/**");
		return new WebSecurityCustomizer() {
			@Override
			public void customize(WebSecurity web) {
				// security 무시할 경로 등록
				// TODO security ignore path 추가
				web.ignoring().antMatchers("/img/**","/js/**","/css/**","/error","/upload/**");
			}
		};
	}
	
	@Bean
	public LoginSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}
	
	@Bean 
	public CustomAccessDeniedHandler customAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean 
	public SecurityFilterChain fileChain(HttpSecurity http) throws Exception{
		
		http.formLogin().loginPage("/user/login")
						.usernameParameter("u_id")
						.passwordParameter("u_pw")
						.loginProcessingUrl("/user/login")
						.successHandler(loginSuccessHandler());
		// remember me
		http.rememberMe().rememberMeCookieName("userCookie")
						 .rememberMeParameter("rememberme").tokenValiditySeconds(6040800);
		
		// session 
		http.sessionManagement()
			.maximumSessions(1)
			.expiredUrl("/logoff")
			// true 이면 최대 세션 수에 도달 했을 때 사용자가 인증하지 못하도록 함.
			// 그렇지 않으면(기본값 : false) 인증하는 사용자는 엑세스 되고 기존 사용자의 세션 완료
			.maxSessionsPreventsLogin(false);
		// 로그아웃 
		http.logout().logoutUrl("/user/logout").logoutSuccessUrl("/").deleteCookies("userCookie");
		
		// denied
		http.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
		
		// interceptor-url
		http.authorizeRequests().mvcMatchers("/mngt/user/**").access("hasRole('ROLE_ADMIN')")
								.mvcMatchers("/mngt/**").access("hasAnyRole('ROLE_MEMBERSHIP','ROLE_ADMIN')")
		                        .mvcMatchers("/user/logout").authenticated()
		                        .mvcMatchers("/user/**","/logoff","/").permitAll()
		                        .mvcMatchers("/**").authenticated();
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	// AuthenticationManager 생성
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
}

























