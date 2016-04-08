package com.findren.homepage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface MemberService {
	public void perMember1(HttpServletRequest request);
	
	public void joinPer(HttpServletRequest request);
	
	public void emailCheck(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception;
}
