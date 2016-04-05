package com.findren.homepage.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//메인 & 회사소개 & 사업분야 컨드롤러

@Controller
public class MainController {
	
	@RequestMapping(value={"/", "/findren"}) //메인
	public String Findren(Model model){
		model.addAttribute("content", "Main/mainBody");
		return "home";
	}
	
	 //회사소개 > 회사소개
	@RequestMapping("/comInfo")
	public String comInfo(Model model){
		model.addAttribute("content", "ComInfo/comInfo");
		return "home";
	}
	
	//회사소개 > 주요고객군
	@RequestMapping("/comMainCustomer") 
	public String comMainCustomer(Model model){
		model.addAttribute("content", "ComInfo/comMainCustomer");
		return "home";
	}

	//회사소개 > 오시는길
	@RequestMapping("/comMap") 
	public String comMap(Model model){
		model.addAttribute("content", "ComInfo/comMap");
		return "home";
	}
	
	//사업분야 > 중국마케팅
	@RequestMapping("/comChinaMkt") 
	public String comChinaMkt(Model model){
		model.addAttribute("content", "ComBiz/comChinaMkt");
		return "home";
	}

	//사업분야 > 중국인채용
	@RequestMapping("/comJob") 
	public String comJob(Model model){
		model.addAttribute("content", "ComBiz/comJob");
		return "home";
	}
	
	// 사업분야 > 위챗공중계정
	@RequestMapping("/comOfficialAccount")
	public String comOfficialAccount(Model model){
		model.addAttribute("content", "ComBiz/comOfficialAccount");
		return "home";
	}
	
	// 사업분야 > 포트폴리오
	@RequestMapping("/comPortfolio")
	public String comPortfolio(Model model){
		model.addAttribute("content", "ComBiz/comPortfolio");
		return "home";
	}
	
	// 사업분야 > 위채페이
	@RequestMapping("/comWechatPay")
	public String comWechatPay(Model model){
		model.addAttribute("content", "ComBiz/comWechatPay");
		return "home";
	}
	
	//사업분야 > 가맹점홍보
	@RequestMapping("/storePromotion")
	public String storePromotion(Model model){
		model.addAttribute("content", "ComBiz/storePromotion");
		return "home";
	}
	

}
