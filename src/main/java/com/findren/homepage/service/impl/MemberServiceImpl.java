package com.findren.homepage.service.impl;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findren.homepage.dao.MemberDao;
import com.findren.homepage.domain.Config;
import com.findren.homepage.domain.Member;
import com.findren.homepage.email.Email;
import com.findren.homepage.email.EmailSender;
import com.findren.homepage.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao mDao;
	@Autowired
	private EmailSender emailSender;
	
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_GROUP = 10;

	public void setmDao(MemberDao mDao) {
		this.mDao = mDao;
	}
	
	@Override
	public void perMember1(HttpServletRequest request) {
		Config cf = mDao.perMember1();
		
		request.setAttribute("cf", cf);
	}
	
	@Override
	public void joinPer(HttpServletRequest request) {
		String fhm_per_address ;
		Member m = new Member();
		m.setFhm_id(request.getParameter("fhm_id"));
		m.setFhm_pw(request.getParameter("fhm_pw"));
		m.setFhm_name(request.getParameter("fhm_name"));
		m.setFhm_per_nation(request.getParameter("fhm_per_nation"));
		m.setFhm_per_email(request.getParameter("fhm_per_email"));
		m.setFhm_com_birth(request.getParameter("fhm_per_birth"));
		m.setFhm_sex(request.getParameter("fhm_sex"));
		m.setFhm_per_phone(request.getParameter("fhm_per_phone"));
		m.setFhm_per_cell(request.getParameter("fhm_per_cell"));
		if(!request.getParameter("fhm_per_addresstext").isEmpty()){
			fhm_per_address = request.getParameter("fhm_per_addresstext");
		}else{
			fhm_per_address = request.getParameter("fhm_per_address1") + request.getParameter("fhm_per_address2");
		}
		m.setFhm_per_address(fhm_per_address);
		mDao.joinPer(m);
	}
	
	@Override
	public void emailCheck(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		Email email = new Email();
		String fhm_id = request.getParameter("fhm_id");
		String fhm_per_email = request.getParameter("fhm_per_email");
		Random random = new Random();
		// 0~999999 수를 받는다
		int cipher = 1000000;
		int randomInteger = random.nextInt(cipher);
		String support = "";
		for (int i = 5; i != 1; i--) {
			if (randomInteger < Math.pow(10, i)) {
				support += "0";
			}
		}
		String sendCode = (support + randomInteger).trim();
		request.getServletContext().setAttribute("sendCode", sendCode);
		String reciver = fhm_per_email;
		String subject = "안녕하세요 중국인 찾기  입니다.";
		String content = "중국인찾기 회원가입 인증 - \n"
				+ "http://172.30.1.14:8080/Findren/checkMemberJoinid="+fhm_id+"&code="+sendCode;
		
		email.setReciver(reciver);
		email.setSubject(subject);
		email.setContent(content);
		emailSender.sendEmail(email);
	}
}
