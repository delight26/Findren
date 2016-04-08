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

import com.findren.homepage.service.impl.WechatidServiceImpl;

@Controller
public class WechatidController {

	@Autowired
	private WechatidServiceImpl nService;
	private static final String filePath = "/resources/file_upload/";

	public void setnService(WechatidServiceImpl nService) {
		this.nService = nService;
	}
	
	//리스트
	@RequestMapping(value = "wechatidList")
	public String wechatidList(HttpServletRequest request, Model model) {
		nService.wechatidList(request);
		model.addAttribute("content", "Wechatid/wechatidList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "wechatidWrite")
	public String wechatidWrite(){
		return "Wechatid/wechatidWrite";
	}
	
	//쓰기결과
	@RequestMapping(value="wechatidWriteResult", method = RequestMethod.POST)
	public String wechatidWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.wechatidWriteResult(request, path, session);
		return "redirect:wechatidList";
	}
	
	//보기
	@RequestMapping(value="wechatidContent")
	public String wechatidContent(HttpServletRequest request){
		nService.wechatidContent(request);
		return "Wechatid/wechatidContent";
	}
	
	//다음글
	@RequestMapping(value="wechatidnext")
	public String wechatidNext(HttpServletRequest request){
		nService.wechatidNext(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Wechatid/wechatidContent";
	}
	
	//이전글
	@RequestMapping(value="wechatidpre")
	public String wechatidPre(HttpServletRequest request){
		nService.wechatidPre(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Wechatid/wechatidContent";
	}
	
	//삭제
	@RequestMapping(value="wechatidDelete", method = RequestMethod.POST)
	public String wechatidDelete(HttpServletRequest request){
		nService.wechatidDelete(request);
		return "redirect:wechatidList";
	}
	
	//업데이트
	@RequestMapping(value="wechatidUpdate")
	public String wechatidUpdate(HttpServletRequest request){
		nService.wechatidUpdate(request);
		return "Wechatid/wechatidUpdate";
	}
	
	//업데이트결과
	@RequestMapping(value="wechatidUpdateResult", method = RequestMethod.POST)
	public String wechatidUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.wechatidUpdateResult(request, path, session);
		return "redirect:wechatidList";
	}
}
