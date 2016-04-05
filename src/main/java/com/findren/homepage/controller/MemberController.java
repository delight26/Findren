package com.findren.homepage.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.findren.homepage.service.MemberService;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

@Controller
public class MemberController {

	@Autowired
	private MemberService mService;
	private static final String filePath = "/resources/file_upload/";

	public void setmService(MemberService mService) {
		this.mService = mService;
	}

	// 회원가입
	@RequestMapping(value = "joinMember")
	public String joinMember() {

		return "Member/selectJoin";
	}

	// 일반회원 약관
	@RequestMapping(value = "perMember1")
	public String perMember1(HttpServletRequest request) {
		mService.perMember1(request);

		return "Member/perMember1";
	}

	// 일반회원 가입
	@RequestMapping(value = "perMember2")
	public String perMember2(HttpServletRequest request) {
		return "Member/perMember2";
	}
	
	//자동등록 방지
	@ResponseBody
	@RequestMapping(value = "validateRecaptcha", method = RequestMethod.POST)
	public String validateRecaptcha(@RequestParam Map<String, String> paramMap) {
	     
	    String check = "Y";
	     
	    ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
	    reCaptcha.setPrivateKey("6LdkmxwTAAAAAFWEOnrxQQD9smJp_GFh9BwZv26h");//Secret key
	 
	    String host = paramMap.get("host");
	    String challenge = paramMap.get("challenge");
	    String res = paramMap.get("response");
	     
	    ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(host, challenge, res);
	 
	    if (reCaptchaResponse.isValid()) {
	        System.out.println("true");
	        check = "Y";
	    } else {
	        System.out.println("false");
	        check = "N";
	    }
	     
	    return check;
	 
	}
	
	//회원 가입 결과
	@RequestMapping(value="joinPer")
	public String joinPer(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		mService.joinPer(request);
		return "Member/joinPer";
	}
}
