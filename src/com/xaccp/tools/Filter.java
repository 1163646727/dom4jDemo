package com.xaccp.tools;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter implements javax.servlet.Filter {

	public void destroy() {
		
	}
	private String code="gbk";
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(code);
		response.setCharacterEncoding(code);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		code=config.getInitParameter("code");
	}

}
