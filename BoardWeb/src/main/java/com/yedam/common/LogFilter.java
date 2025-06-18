package com.yedam.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{
	//List<String> list = new ArrayList<>();
	//생성자
	public LogFilter() {
		System.out.println("필터객체 생성.");
		//list.add("host번호");
	}
	//서블릿-httpServletRequest
	//어떤페이지요청해도 필터가 다 적용됨,FilterChain 서블릿정보읽어들일때,fitler정보다가짐
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("서블릿 실행전.");
		
		//어떤ip요청..getRemoteAddr접속ip주소
		String host = req.getRemoteAddr();
		String port = "" + req.getRemotePort();
		//System.out.println("접속HOST: " + host + "접속PORT: " + port);
		
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String page = uri.substring(context.length());
		System.out.println("IP: "+ host+", Page: "+page);
//		if(host.equals("192.168.0.17")) {
//			return;
//		}
//		if(!host.equals("0:0:0:0:0:0:0:1")) {//localhost만들어가짐
//			return;
//		}
		if(!host.equals("0:0:0:0:0:0:0:1")) {//localhost만들어가짐
			return;
		}
//		if(list.("0:0:0:0:0:0:0:1")) {//localhost만들어가짐
//			return;
//		}
		chain.doFilter(req, resp);//서블릿 실행.
		
		System.out.println("서블릿 실행후.");
	}
	
}
