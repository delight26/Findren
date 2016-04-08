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

import com.findren.homepage.service.impl.OnlineServiceImpl;

@Controller
public class OnlineController {

	@Autowired
	private OnlineServiceImpl onlineService;
	private static final String filePath = "/resources/file_upload/";

	public void setonlineService(OnlineServiceImpl onlineService) {
		this.onlineService = onlineService;
	}
	
	//리스트
	@RequestMapping(value = "onlineList")
	public String onlineList(HttpServletRequest request, Model model) {
		onlineService.onlineList(request);
		model.addAttribute("content", "Online/onlineList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "onlineWrite")
	public String onlineWrite(Model model){
		model.addAttribute("content", "Online/onlineWrite" );
		return "home";
	}
	
	//쓰기결과
	@RequestMapping(value="onlineWriteResult", method = RequestMethod.POST)
	public String onlineWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		onlineService.onlineWriteResult(request, path, session);
		return "redirect:onlineList";
	}
	
	//보기
	@RequestMapping(value="onlineContent")
	public String onlineContent(HttpServletRequest request, Model model){
		onlineService.onlineContent(request);
		model.addAttribute("content", "Online/onlineContent");
		return "home";
	}
	
	//다음글
	@RequestMapping(value="onlinenext")
	public String onlineNext(HttpServletRequest request, Model model){
		onlineService.onlineNext(request);
		model.addAttribute("content", "Online/onlineConetent");
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//이전글
	@RequestMapping(value="onlinepre")
	public String onlinePre(HttpServletRequest request, Model model){
		onlineService.onlinePre(request);
		model.addAttribute("content", "Online/onlineConetent");
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//삭제
	@RequestMapping(value="onlineDelete", method = RequestMethod.POST)
	public String onlineDelete(HttpServletRequest request){
		onlineService.onlineDelete(request);
		return "redirect:onlineList";
	}
	
	//업데이트
	@RequestMapping(value="onlineUpdate")
	public String onlineUpdate(HttpServletRequest request, Model model){
		onlineService.onlineUpdate(request);
		model.addAttribute("content", "Online/onlineUpdate");
		return "home";
	}
	
	//업데이트결과
	@RequestMapping(value="onlineUpdateResult", method = RequestMethod.POST)
	public String onlineUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		onlineService.onlineUpdateResult(request, path, session);
		return "redirect:onlineList";
	}
}
