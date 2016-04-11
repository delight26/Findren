package com.findren.homepage.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.findren.homepage.dao.MemberDao;
import com.findren.homepage.domain.Config;
import com.findren.homepage.domain.Member;
import com.findren.homepage.email.Email;
import com.findren.homepage.email.EmailSender;
import com.findren.homepage.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

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
		String fhm_per_address;
		Member checkid = mDao.checkId(request.getParameter("fhm_id"));
		if (checkid != null ) {
			request.setAttribute("message", "이미 아이디가 존재합니다.");
			request.setAttribute("returnUrl", "/Findren/perMember2");
		} else {
			Member m = new Member();
			m.setFhm_type(1);
			m.setFhm_id(request.getParameter("fhm_id"));
			m.setFhm_pw(request.getParameter("fhm_pw"));
			m.setFhm_name(request.getParameter("fhm_name"));
			m.setFhm_per_nation(request.getParameter("fhm_per_nation"));
			m.setFhm_per_email(request.getParameter("fhm_per_email"));
			m.setFhm_com_birth(request.getParameter("fhm_per_birth"));
			m.setFhm_sex(request.getParameter("fhm_sex"));
			m.setFhm_per_phone(request.getParameter("fhm_per_phone"));
			m.setFhm_per_cell(request.getParameter("fhm_per_cell"));
			if (request.getParameter("fhm_per_nation").equals("korea")) {
				fhm_per_address = request.getParameter("fhm_per_address1") + request.getParameter("fhm_per_address2");
			} else {
				fhm_per_address = request.getParameter("fhm_per_addresstext");
			}
			m.setFhm_per_address(fhm_per_address);
			mDao.joinPer(m);
		}
	}

	@Override
	public void emailCheck(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		Email email = new Email();
		String reciver;
		String fhm_id = request.getParameter("fhm_id");
		
		if(request.getParameter("fhm_per_email")!=null){
			System.out.println(1);
			reciver = request.getParameter("fhm_per_email");
		} else{
			System.out.println(2);
			reciver = request.getParameter("fhm_com_email");
		}
		
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
		
		String subject = "안녕하세요 중국인 찾기  입니다.";
		String content = "중국인찾기 회원가입 인증 - \n" + "http://172.30.1.14:8080/Findren/checkMemberJoinid=" + fhm_id + "&code="
				+ sendCode;

		email.setReciver(reciver);
		email.setSubject(subject);
		email.setContent(content);
		emailSender.sendEmail(email);
	}

	@Override
	public void comMember1(HttpServletRequest request) {
		Config cf = mDao.perMember1();

		request.setAttribute("cf", cf);
	}

	@Override
	public void joinCom(MultipartHttpServletRequest request, String path) throws IllegalStateException, IOException {
		request.setCharacterEncoding("utf-8");
		String fhm_com_address;
		Member checkid = mDao.checkId(request.getParameter("fhm_id"));
		if (checkid!=null) {
			request.setAttribute("message", "이미 아이디가 존재합니다.");
			request.setAttribute("returnUrl", "/Findren/comMember2");
		} else {
			MultipartFile multipartFile1 = request.getFile("fhm_com_logo");
			Member m = new Member();
			m.setFhm_com_part(request.getParameter("fhm_com_part"));
			m.setFhm_com_nation(request.getParameter("fhm_com_nation"));
			m.setFhm_id(request.getParameter("fhm_id"));
			m.setFhm_pw(request.getParameter("fhm_pw"));
			m.setFhm_com_emp(request.getParameter("fhm_com_emp"));
			m.setFhm_com_style(request.getParameter("fhm_com_style"));
			m.setFhm_com_birth(request.getParameter("fhm_com_birth"));
			m.setFhm_com_person(Integer.valueOf(request.getParameter("fhm_com_person")));
			m.setFhm_com_biz(request.getParameter("fhm_com_biz"));
			m.setFhm_com_homepage(request.getParameter("fhm_com_homepage"));
			m.setFhm_com_no(request.getParameter("fhm_com_no1") + "-" + request.getParameter("fhm_com_no2") + "-"
					+ request.getParameter("fhm_com_no3"));
			m.setFhm_com_ceo(request.getParameter("fhm_com_ceo"));
			m.setFhm_com_name(request.getParameter("fhm_com_name"));
			m.setFhm_com_phone(request.getParameter("fhm_com_phone"));
			m.setFhm_com_email(request.getParameter("fhm_com_emial"));
			if (request.getParameter("fhm_com_nation").equals("korea")) {
				fhm_com_address = request.getParameter("fhm_com_address1") + request.getParameter("fhm_com_address2");
			} else {
				fhm_com_address = request.getParameter("fhm_com_addresstext");
			}
			m.setFhm_com_address(fhm_com_address);
			m.setFhm_com_logo("");
			if(request.getParameter("fhm_mailing")!=null){
				m.setFhm_mailig(request.getParameter("fhm_mailing"));
			}else{
				m.setFhm_mailig("N");
			}
			if (!multipartFile1.isEmpty()) {
				String filename_ext1 = multipartFile1.getOriginalFilename()
						.substring(multipartFile1.getOriginalFilename().lastIndexOf(".") + 1);
				filename_ext1 = filename_ext1.toLowerCase();
				String realFileNm1 = "";
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
				String today1 = formatter.format(new java.util.Date());
				realFileNm1 = today1 + UUID.randomUUID().toString() + multipartFile1.getOriginalFilename()
						.substring(multipartFile1.getOriginalFilename().lastIndexOf("."));
				String rlFileNm1 = realFileNm1;
				File file1 = new File(path, rlFileNm1);
				multipartFile1.transferTo(file1);
				m.setFhm_com_logo(rlFileNm1);
			}
			mDao.joinCom(m);
		}
	}
	
	@Override
	public void loginResult(HttpServletRequest request, HttpSession session) {
		String fhm_pw = request.getParameter("fhm_pw");
		Member checkid = mDao.checkId(request.getParameter("fhm_id"));
		if(checkid != null){
			if(checkid.getFhm_pw().equals(fhm_pw)){
				session.setAttribute("member", checkid);
			} else{
				request.setAttribute("message", "비밀번호가 맞지 않습니다.");
				request.setAttribute("returnUrl", "/Findren/login");
			}
		} else{
			request.setAttribute("message", "아이디가 존재하지 않습니다.");
			request.setAttribute("returnUrl", "/Findren/login");
		}
	}
}
