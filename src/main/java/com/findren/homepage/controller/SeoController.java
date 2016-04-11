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

import com.findren.homepage.service.impl.SeoServiceImpl;

@Controller
public class SeoController {

	@Autowired
	private SeoServiceImpl seoService;
	private static final String filePath = "/resources/file_upload/";

	public void setseoService(SeoServiceImpl seoService) {
		this.seoService = seoService;
	}
	
	//리스트
	@RequestMapping(value = "seoList")
	public String seoList(HttpServletRequest request, Model model) {
		seoService.seoList(request);
		model.addAttribute("content", "SEO/seoList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "seoWrite")
	public String seoWrite(Model model){
		model.addAttribute("content", "SEO/seoWrite");
		return "home";
	}
	
	//쓰기결과
	@RequestMapping(value="seoWriteResult", method = RequestMethod.POST)
	public String seoWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		seoService.seoWriteResult(request, path, session);
		return "redirect:seoList";
	}
	
	//보기
	@RequestMapping(value="seoContent")
	public String seoContent(HttpServletRequest request, Model model){
		seoService.seoContent(request);
		model.addAttribute("content", "SEO/seoContent");
		return "home";
	}
	
	//다음글
	@RequestMapping(value="seonext")
	public String seoNext(HttpServletRequest request, Model model){
		seoService.seoNext(request);
		model.addAttribute("content", "SEO/seoContent");
		if (request.getAttribute("seo") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//이전글
	@RequestMapping(value="seopre")
	public String seoPre(HttpServletRequest request, Model model){
		seoService.seoPre(request);
		model.addAttribute("content", "SEO/seoContent");
		if (request.getAttribute("seo") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//삭제
	@RequestMapping(value="seoDelete", method = RequestMethod.POST)
	public String seoDelete(HttpServletRequest request){
		seoService.seoDelete(request);
		return "redirect:seoList";
	}
	
	//업데이트
	@RequestMapping(value="seoUpdate")
	public String seoUpdate(HttpServletRequest request, Model model){
		model.addAttribute("content", "SEO/seoUpdate");
		seoService.seoUpdate(request);
		return "home";
	}
	
	//업데이트결과
	@RequestMapping(value="seoUpdateResult", method = RequestMethod.POST)
	public String seoUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		seoService.seoUpdateResult(request, path, session);
		return "redirect:seoList";
	}
}
