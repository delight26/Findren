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

import com.findren.homepage.service.impl.SnsServiceImpl;

@Controller
public class SnsController {

	@Autowired
	private SnsServiceImpl snsService;
	private static final String filePath = "/resources/file_upload/";

	public void setsnsService(SnsServiceImpl snsService) {
		this.snsService = snsService;
	}
	
	//리스트
	@RequestMapping(value = "snsList")
	public String snsList(HttpServletRequest request, Model model) {
		snsService.snsList(request);
		model.addAttribute("content", "SNS/snsList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "snsWrite")
	public String snsWrite(){
		return "SNS/snsWrite";
	}
	
	//쓰기결과
	@RequestMapping(value="snsWriteResult", method = RequestMethod.POST)
	public String snsWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		snsService.snsWriteResult(request, path, session);
		return "redirect:snsList";
	}
	
	//보기
	@RequestMapping(value="snsContent")
	public String snsContent(HttpServletRequest request){
		snsService.snsContent(request);
		return "SNS/snsContent";
	}
	
	//다음글
	@RequestMapping(value="snsnext")
	public String snsNext(HttpServletRequest request){
		snsService.snsNext(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "SNS/snsContent";
	}
	
	//이전글
	@RequestMapping(value="snspre")
	public String snsPre(HttpServletRequest request){
		snsService.snsPre(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "SNS/snsContent";
	}
	
	//삭제
	@RequestMapping(value="snsDelete", method = RequestMethod.POST)
	public String snsDelete(HttpServletRequest request){
		snsService.snsDelete(request);
		return "redirect:snsList";
	}
	
	//업데이트
	@RequestMapping(value="snsUpdate")
	public String snsUpdate(HttpServletRequest request){
		snsService.snsUpdate(request);
		return "SNS/snsUpdate";
	}
	
	//업데이트결과
	@RequestMapping(value="snsUpdateResult", method = RequestMethod.POST)
	public String snsUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		snsService.snsUpdateResult(request, path, session);
		return "redirect:snsList";
	}
}
