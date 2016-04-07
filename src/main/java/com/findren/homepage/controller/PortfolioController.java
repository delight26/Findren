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

import com.findren.homepage.service.PortfolioService;


@Controller
public class PortfolioController {

	@Autowired
	private PortfolioService nService;
	private static final String filePath = "/resources/file_upload/";

	public void setnService(PortfolioService nService) {
		this.nService = nService;
	}
	
	//리스트
	@RequestMapping(value = "PotfolioList")
	public String PotfolioList(HttpServletRequest request, Model model) {
		nService.portfolioList(request);
		model.addAttribute("content", "Portfolio/portfolioList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "portfolioWrite")
	public String portfolioWrite(){
		return "Portfolio/portfolioWrite";
	}
	
	//쓰기결과
	@RequestMapping(value="portfolioWriteResult", method = RequestMethod.POST)
	public String portfolioWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.portfolioWriteResult(request, path, session);
		return "redirect:portfolioList";
	}
	
	//보기
	@RequestMapping(value="portfolioContent")
	public String portfolioContent(HttpServletRequest request){
		nService.portfolioContent(request);
		return "Portfolio/portfolioContent";
	}
	
	//다음글
	@RequestMapping(value="portfolionext")
	public String portfolioNext(HttpServletRequest request){
		nService.portfolioNext(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Portfolio/portfolioContent";
	}
	
	//이전글
	@RequestMapping(value="portfoliopre")
	public String portfolioPre(HttpServletRequest request){
		nService.portfolioPre(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Portfolio/portfolioContent";
	}
	
	//삭제
	@RequestMapping(value="portfolioDelete", method = RequestMethod.POST)
	public String portfolioDelete(HttpServletRequest request){
		nService.portfolioDelete(request);
		return "redirect:portfolioList";
	}
	
	//업데이트
	@RequestMapping(value="portfolioUpdate")
	public String portfolioUpdate(HttpServletRequest request){
		nService.portfolioUpdate(request);
		return "Portfolio/portfolioUpdate";
	}
	
	//업데이트결과
	@RequestMapping(value="portfolioUpdateResult", method = RequestMethod.POST)
	public String portfolioUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.portfolioUpdateResult(request, path, session);
		return "redirect:portfolioList";
	}
}
