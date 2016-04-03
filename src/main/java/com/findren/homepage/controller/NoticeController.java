package com.findren.homepage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.findren.homepage.service.impl.NoticeServiceImpl;

@Controller
public class NoticeController {

	@Autowired
	private NoticeServiceImpl nService;
	private static final String filePath = "/resources/file_upload/";

	public void setnService(NoticeServiceImpl nService) {
		this.nService = nService;
	}
	
	@RequestMapping(value = "noticeList")
	public String noticeList(HttpServletRequest request) {
		nService.noticeList(request);
		return "Notice/noticeList";
	}
	
	@RequestMapping(value = "noticeWrite")
	public String noticeWrite(){
		return "Notice/noticeWrite";
	}
	@RequestMapping(value="noticeWriteResult", method = RequestMethod.POST)
	public String noticeWriteResult(MultipartHttpServletRequest request) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.noticeWriteResult(request, path);
		return "redirect:noticeList";
	}
	@RequestMapping(value="noticeContent")
	public String noticeContent(HttpServletRequest request){
		nService.noticeContent(request);
		return "Notice/noticeContent";
	}
	@RequestMapping(value="noticenext")
	public String noticeNext(HttpServletRequest request){
		nService.noticeNext(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Notice/noticeContent";
	}
	@RequestMapping(value="noticepre")
	public String noticePre(HttpServletRequest request){
		nService.noticePre(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Notice/noticeContent";
	}
	
	@RequestMapping(value="noticeDelete", method = RequestMethod.POST)
	public String noticeDelete(HttpServletRequest request){
		nService.noticeDelete(request);
		return "redirect:noticeList";
	}
	
	@RequestMapping(value="noticeUpdate")
	public String noticeUpdate(HttpServletRequest request){
		nService.noticeUpdate(request);
		return "Notice/noticeUpdate";
	}
	
	@RequestMapping(value="noticeUpdateResult", method = RequestMethod.POST)
	public String noticeUpdateResult(MultipartHttpServletRequest request) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.noticeUpdateResult(request, path);
		return "redirect:noticeList";
	}
}
