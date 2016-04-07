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
	private SnsServiceImpl nService;
	private static final String filePath = "/resources/file_upload/";

	public void setnService(SnsServiceImpl nService) {
		this.nService = nService;
	}
	
	//리스트
	@RequestMapping(value = "snsList")
	public String snsList(HttpServletRequest request, Model model) {
		nService.snsList(request);
		model.addAttribute("content", "Sns/snsList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "snsWrite")
	public String snsWrite(){
		return "Sns/snsWrite";
	}
	
	//쓰기결과
	@RequestMapping(value="snsWriteResult", method = RequestMethod.POST)
	public String snsWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.snsWriteResult(request, path, session);
		return "redirect:snsList";
	}
	
	//보기
	@RequestMapping(value="snsContent")
	public String snsContent(HttpServletRequest request){
		nService.snsContent(request);
		return "Sns/snsContent";
	}
	
	//다음글
	@RequestMapping(value="snsnext")
	public String snsNext(HttpServletRequest request){
		nService.snsNext(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Sns/snsContent";
	}
	
	//이전글
	@RequestMapping(value="snspre")
	public String snsPre(HttpServletRequest request){
		nService.snsPre(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Sns/snsContent";
	}
	
	//삭제
	@RequestMapping(value="snsDelete", method = RequestMethod.POST)
	public String snsDelete(HttpServletRequest request){
		nService.snsDelete(request);
		return "redirect:snsList";
	}
	
	//업데이트
	@RequestMapping(value="snsUpdate")
	public String snsUpdate(HttpServletRequest request){
		nService.snsUpdate(request);
		return "Sns/snsUpdate";
	}
	
	//업데이트결과
	@RequestMapping(value="snsUpdateResult", method = RequestMethod.POST)
	public String snsUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.snsUpdateResult(request, path, session);
		return "redirect:snsList";
	}
}
