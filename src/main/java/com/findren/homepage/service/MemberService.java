package com.findren.homepage.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface MemberService {
	public void perMember1(HttpServletRequest request);
	
	public void joinPer(HttpServletRequest request);
	
	public void emailCheck(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception;
	
	public void comMember1(HttpServletRequest request);
	
	public void joinCom(MultipartHttpServletRequest request, String path) throws IllegalStateException, IOException;
	
	public void loginResult(HttpServletRequest request, HttpSession session);
}
