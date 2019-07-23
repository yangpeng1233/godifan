package com.action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CodeFilter implements Filter{

	private String codestr;
	
	public void destroy() {
		this.codestr = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		
		 if(codestr != null){
			 request.setCharacterEncoding(codestr);
		     response.setCharacterEncoding(codestr);
			 response.setContentType("text/html;charset="+codestr);
		 }
		 
		 arg2.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		codestr = arg0.getInitParameter("codestr");
		System.out.println(" codestr = "+codestr);
	}

}
