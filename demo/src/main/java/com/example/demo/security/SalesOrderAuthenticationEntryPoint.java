package com.example.demo.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class SalesOrderAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	
	@Override
	public void commence(HttpServletRequest request,HttpServletResponse responce,
			AuthenticationException authException) throws IOException,ServletException {
		responce.addHeader("WWW-Authenticate","Basic relam=\""+ getRealmName()+"\"");
		responce.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("Topic security application Realm");
	}
}
