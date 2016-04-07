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
	private OnlineServiceImpl nService;
	private static final String filePath = "/resources/file_upload/";

	public void setnService(OnlineServiceImpl nService) {
		this.nService = nService;
	}
	
	//리스트
	@RequestMapping(value = "onlineList")
	public String onlineList(HttpServletRequest request, Model model) {
		nService.onlineList(request);
		model.addAttribute("content", "Online/onlineList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "onlineWrite")
	public String onlineWrite(){
		return "Online/onlineWrite";
	}
	
	//쓰기결과
	@RequestMapping(value="onlineWriteResult", method = RequestMethod.POST)
	public String onlineWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.onlineWriteResult(request, path, session);
		return "redirect:onlineList";
	}
	
	//보기
	@RequestMapping(value="onlineContent")
	public String onlineContent(HttpServletRequest request){
		nService.onlineContent(request);
		return "Online/onlineContent";
	}
	
	//다음글
	@RequestMapping(value="onlinenext")
	public String onlineNext(HttpServletRequest request){
		nService.onlineNext(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Online/onlineContent";
	}
	
	//이전글
	@RequestMapping(value="onlinepre")
	public String onlinePre(HttpServletRequest request){
		nService.onlinePre(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Online/onlineContent";
	}
	
	//삭제
	@RequestMapping(value="onlineDelete", method = RequestMethod.POST)
	public String onlineDelete(HttpServletRequest request){
		nService.onlineDelete(request);
		return "redirect:onlineList";
	}
	
	//업데이트
	@RequestMapping(value="onlineUpdate")
	public String onlineUpdate(HttpServletRequest request){
		nService.onlineUpdate(request);
		return "Online/onlineUpdate";
	}
	
	//업데이트결과
	@RequestMapping(value="onlineUpdateResult", method = RequestMethod.POST)
	public String onlineUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.onlineUpdateResult(request, path, session);
		return "redirect:onlineList";
	}
}
