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

import com.findren.homepage.service.impl.WechatpayImpl;


@Controller
public class WechatpayController {

	@Autowired
	private WechatpayImpl wpService;
	private static final String filePath = "/resources/file_upload/";

	public void setwpService(WechatpayImpl wpService) {
		this.wpService = wpService;
	}
	
	//리스트
	@RequestMapping(value = "wechatpayList")
	public String wechatpayList(HttpServletRequest request, Model model) {
		wpService.wechatpayList(request);
		model.addAttribute("content", "Wechatpay/wechatpayList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "wechatpayWrite")
	public String wechatpayWrite(){
		return "Wechatpay/wechatpayWrite";
	}
	
	//쓰기결과
	@RequestMapping(value="wechatpayWriteResult", method = RequestMethod.POST)
	public String wechatpayWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		wpService.wechatpayWriteResult(request, path, session);
		return "redirect:wechatpayList";
	}
	
	//보기
	@RequestMapping(value="wechatpayContent")
	public String wechatpayContent(HttpServletRequest request){
		wpService.wechatpayContent(request);
		return "Wechatpay/wechatpayContent";
	}
	
	//다음글
	@RequestMapping(value="wechatpaynext")
	public String wechatpayNext(HttpServletRequest request){
		wpService.wechatpayNext(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Wechatpay/wechatpayContent";
	}
	
	//이전글
	@RequestMapping(value="wechatpaypre")
	public String wechatpayPre(HttpServletRequest request){
		wpService.wechatpayPre(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Wechatpay/wechatpayContent";
	}
	
	//삭제
	@RequestMapping(value="wechatpayDelete", method = RequestMethod.POST)
	public String wechatpayDelete(HttpServletRequest request){
		wpService.wechatpayDelete(request);
		return "redirect:wechatpayList";
	}
	
	//업데이트
	@RequestMapping(value="wechatpayUpdate")
	public String wechatpayUpdate(HttpServletRequest request){
		wpService.wechatpayUpdate(request);
		return "Wechatpay/wechatpayUpdate";
	}
	
	//업데이트결과
	@RequestMapping(value="wechatpayUpdateResult", method = RequestMethod.POST)
	public String wechatpayUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		wpService.wechatpayUpdateResult(request, path, session);
		return "redirect:wechatpayList";
	}
}
