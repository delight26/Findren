package com.findren.homepage.controller;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String joinMember(Model model) {
		model.addAttribute("content", "Member/selectJoin");
		return "home";
	}

	// 일반회원 약관
	@RequestMapping(value = "perMember1")
	public String perMember1(HttpServletRequest request, Model model) {
		mService.perMember1(request);
		model.addAttribute("content", "Member/perMember1");
		return "home";
	}

	// 일반회원 가입
	@RequestMapping(value = "perMember2")
	public String perMember2(HttpServletRequest request, Model model) {
		model.addAttribute("content", "Member/perMember2");
		return "home";
	}

	// 자동등록 방지
	@ResponseBody
	@RequestMapping(value = "validateRecaptcha", method = RequestMethod.POST)
	public String validateRecaptcha(@RequestParam Map<String, String> paramMap) {

		String check = "Y";

		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LdkmxwTAAAAAFWEOnrxQQD9smJp_GFh9BwZv26h");// Secret
																			// key

		String host = paramMap.get("host");
		String challenge = paramMap.get("challenge");
		String res = paramMap.get("response");

		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(host, challenge, res);

		if (reCaptchaResponse.isValid()) {
			check = "Y";
		} else {
			check = "N";
		}

		return check;

	}

	// 회원 가입 결과
	@RequestMapping(value = "joinPer", method = RequestMethod.POST)
	public String joinPer(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		mService.joinPer(request);
		if (request.getAttribute("message") != null) {
			return "alertAndRedirect";
		} else {
			mService.emailCheck(request, response, session);
			model.addAttribute("content", "Member/joinResult");
			return "home";
		}
	}

	// 주소 ajax
	@RequestMapping(value = "peraddrsearch")
	public String peraddrSearch(Model model) {
		return "Member/perAddrSearch";
	}

	// 기업회원 약관
	@RequestMapping(value = "comMember1")
	public String comMember1(HttpServletRequest request, Model model) {
		mService.comMember1(request);
		model.addAttribute("content", "Member/comMember1");
		return "home";
	}

	// 기업회원 가입
	@RequestMapping(value = "comMember2")
	public String comMember2(HttpServletRequest request, Model model) {
		model.addAttribute("content", "Member/comMember2");
		return "home";
	}

	// 회원 가입 결과
	@RequestMapping(value = "joinCom", method = RequestMethod.POST)
	public String joinCom(Model model, MultipartHttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		String path = request.getServletContext().getRealPath(filePath);
		mService.joinCom(request, path);
		if (request.getAttribute("message") != null) {
			return "alertAndRedirect";
		} else {
			mService.emailCheck(request, response, session);
			model.addAttribute("content", "Member/joinResult");
//			return "Member/joinResult";
			return "home";
		}
	}

	// 주소 ajax
	@RequestMapping(value = "comaddrsearch")
	public String comaddrSearch() {
		return "Member/comAddrSearch";
	}
	
	//로그인
	@RequestMapping(value="login")
	public String login(Model model){
		model.addAttribute("content", "Member/login");
		return "home";
	}
	
	//로그인 결과
	@RequestMapping(value="loginresult",  method = RequestMethod.POST)
	public String loginResult(HttpServletRequest request, HttpSession session){
		mService.loginResult(request, session);
//		return "redirect:/";
		return "home";
	}
}
