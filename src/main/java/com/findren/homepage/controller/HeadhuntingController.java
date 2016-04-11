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

import com.findren.homepage.service.impl.HeadhuntingServiceImpl;

@Controller
public class HeadhuntingController {

	@Autowired
	private HeadhuntingServiceImpl headhuntingService;
	private static final String filePath = "/resources/file_upload/";

	public void setheadhuntingService(HeadhuntingServiceImpl headhuntingService) {
		this.headhuntingService = headhuntingService;
	}

	//리스트
	@RequestMapping(value = "headhuntingList")
	public String headhuntingList(HttpServletRequest request, Model model) {
		headhuntingService.headhuntingList(request);
		model.addAttribute("content", "Headhunting/headhuntingList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "headhuntingWrite")
	public String headhuntingWrite(Model model){
		model.addAttribute("content", "Headhunting/headhuntingWrite" );
		return "home";
	}
	
	//쓰기결과
	@RequestMapping(value="headhuntingWriteResult", method = RequestMethod.POST)
	public String headhuntingWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		headhuntingService.headhuntingWriteResult(request, path, session);
		return "redirect:headhuntingList";
	}
	
	//보기
	@RequestMapping(value="headhuntingContent")
	public String headhuntingContent(HttpServletRequest request, Model model){
		headhuntingService.headhuntingContent(request);
		model.addAttribute("content", "Headhunting/headhuntingContent");
		return "home";
	}
	
	//다음글
	@RequestMapping(value="headhuntingnext")
	public String headhuntingNext(HttpServletRequest request, Model model){
		headhuntingService.headhuntingNext(request);
		model.addAttribute("content", "Headhunting/headhuntingConetent");
		if (request.getAttribute("headhunting") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//이전글
	@RequestMapping(value="headhuntingpre")
	public String headhuntingPre(HttpServletRequest request, Model model){
		headhuntingService.headhuntingPre(request);
		model.addAttribute("content", "Headhunting/headhuntingConetent");
		if (request.getAttribute("headhunting") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//삭제
	@RequestMapping(value="headhuntingDelete", method = RequestMethod.POST)
	public String headhuntingDelete(HttpServletRequest request){
		headhuntingService.headhuntingDelete(request);
		return "redirect:headhuntingList";
	}
	
	//업데이트
	@RequestMapping(value="headhuntingUpdate")
	public String headhuntingUpdate(HttpServletRequest request, Model model){
		headhuntingService.headhuntingUpdate(request);
		model.addAttribute("content", "Headhunting/headhuntingUpdate");
		return "home";
	}
	
	//업데이트결과
	@RequestMapping(value="headhuntingUpdateResult", method = RequestMethod.POST)
	public String headhuntingUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		headhuntingService.headhuntingUpdateResult(request, path, session);
		return "redirect:headhuntingList";
	}
}
