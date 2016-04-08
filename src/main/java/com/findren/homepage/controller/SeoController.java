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
	private SeoServiceImpl nService;
	private static final String filePath = "/resources/file_upload/";

	public void setnService(SeoServiceImpl nService) {
		this.nService = nService;
	}
	
	//리스트
	@RequestMapping(value = "seoList")
	public String seoList(HttpServletRequest request, Model model) {
		nService.seoList(request);
		model.addAttribute("content", "Seo/seoList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "seoWrite")
	public String seoWrite(){
		return "Seo/seoWrite";
	}
	
	//쓰기결과
	@RequestMapping(value="seoWriteResult", method = RequestMethod.POST)
	public String seoWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.seoWriteResult(request, path, session);
		return "redirect:seoList";
	}
	
	//보기
	@RequestMapping(value="seoContent")
	public String seoContent(HttpServletRequest request){
		nService.seoContent(request);
		return "Seo/seoContent";
	}
	
	//다음글
	@RequestMapping(value="seonext")
	public String seoNext(HttpServletRequest request){
		nService.seoNext(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Seo/seoContent";
	}
	
	//이전글
	@RequestMapping(value="seopre")
	public String seoPre(HttpServletRequest request){
		nService.seoPre(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Seo/seoContent";
	}
	
	//삭제
	@RequestMapping(value="seoDelete", method = RequestMethod.POST)
	public String seoDelete(HttpServletRequest request){
		nService.seoDelete(request);
		return "redirect:seoList";
	}
	
	//업데이트
	@RequestMapping(value="seoUpdate")
	public String seoUpdate(HttpServletRequest request){
		nService.seoUpdate(request);
		return "Seo/seoUpdate";
	}
	
	//업데이트결과
	@RequestMapping(value="seoUpdateResult", method = RequestMethod.POST)
	public String seoUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.seoUpdateResult(request, path, session);
		return "redirect:seoList";
	}
}
