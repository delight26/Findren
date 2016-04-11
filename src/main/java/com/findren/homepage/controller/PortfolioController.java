package com.findren.homepage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.findren.homepage.service.impl.PortfolioServiceImpl;


@Controller
public class PortfolioController {

	@Autowired
	private PortfolioServiceImpl portfolioService;
	private static final String filePath = "/resources/file_upload/";

	public void setportfolioService(PortfolioServiceImpl portfolioService) {
		this.portfolioService = portfolioService;
	}
	
	//리스트
	@RequestMapping(value = "portfolioList")
	public String portfolioList(HttpServletRequest request, Model model) {
		portfolioService.portfolioList(request);
		model.addAttribute("content", "Portfolio/portfolioList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "portfolioWrite")
	public String portfolioWrite(Model model){
		model.addAttribute("content", "Portfolio/portfolioWrite");
		return "home";
	}
	
	//쓰기결과
	@RequestMapping(value="portfolioWriteResult", method = RequestMethod.POST)
	public String portfolioWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		portfolioService.portfolioWriteResult(request, path, session);
		return "redirect:portfolioList";
	}
	
	//보기
	@RequestMapping(value="portfolioContent")
	public String portfolioContent(HttpServletRequest request,Model model){
		portfolioService.portfolioContent(request);
		model.addAttribute("content", "Portfolio/portfolioContent");
		return "home";
	}
	
	//다음글
	@RequestMapping(value="portfolioNext")
	public String portfolioNext(HttpServletRequest request, Model model){
		portfolioService.portfolioNext(request);
		model.addAttribute("content", "Portfolio/portfolioContent");
		
		if (request.getAttribute("portfolio") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//이전글
	@RequestMapping(value="portfolioPre")
	public String portfolioPre(HttpServletRequest request, Model model){
		portfolioService.portfolioPre(request);
		model.addAttribute("content", "Portfolio/portfolioContent");
		
		if (request.getAttribute("portfolio") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//삭제
	@RequestMapping(value="portfolioDelete", method = RequestMethod.POST)
	public String portfolioDelete(HttpServletRequest request){
		portfolioService.portfolioDelete(request);
		return "redirect:portfolioList";
	}
	
	//업데이트
	@RequestMapping(value="portfolioUpdate")
	public String portfolioUpdate(HttpServletRequest request, Model model){
		portfolioService.portfolioUpdate(request);
		model.addAttribute("content", "Portfolio/portfolioUpdate");
		return "home";
	}
	
	//업데이트결과
	@RequestMapping(value="portfolioUpdateResult", method = RequestMethod.POST)
	public String portfolioUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		portfolioService.portfolioUpdateResult(request, path, session);
		return "redirect:portfolioList";
	}
}
