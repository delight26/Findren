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

import com.findren.homepage.service.impl.NoticeServiceImpl;

@Controller
public class NoticeController {

	@Autowired
	private NoticeServiceImpl nService;
	private static final String filePath = "/resources/file_upload/";

	public void setnService(NoticeServiceImpl nService) {
		this.nService = nService;
	}
	
	//리스트
	@RequestMapping(value = "noticeList")
	public String noticeList(HttpServletRequest request, Model model) {
		nService.noticeList(request);
		model.addAttribute("content", "Notice/noticeList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "noticeWrite")
	public String noticeWrite(Model model){
		model.addAttribute("content", "Notice/noticeWrite");
		return "home";
	}
	
	//쓰기결과
	@RequestMapping(value="noticeWriteResult", method = RequestMethod.POST)
	public String noticeWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.noticeWriteResult(request, path, session);
		return "redirect:noticeList";
	}
	
	//보기
	@RequestMapping(value="noticeContent")
	public String noticeContent(HttpServletRequest request,Model model){
		nService.noticeContent(request);
		model.addAttribute("content", "Notice/noticeContent");
		return "home";
	}
	
	//다음글
	@RequestMapping(value="noticenext")
	public String noticeNext(HttpServletRequest request, Model model){
		nService.noticeNext(request);
		model.addAttribute("content", "Notice/noticeContent");
		
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//이전글
	@RequestMapping(value="noticepre")
	public String noticePre(HttpServletRequest request, Model model){
		nService.noticePre(request);
		model.addAttribute("content", "Notice/noticeContent");
		
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//삭제
	@RequestMapping(value="noticeDelete", method = RequestMethod.POST)
	public String noticeDelete(HttpServletRequest request){
		nService.noticeDelete(request);
		return "redirect:noticeList";
	}
	
	//업데이트
	@RequestMapping(value="noticeUpdate")
	public String noticeUpdate(HttpServletRequest request, Model model){
		nService.noticeUpdate(request);
		model.addAttribute("content", "Notice/noticeUpdate");
		return "home";
	}
	
	//업데이트결과
	@RequestMapping(value="noticeUpdateResult", method = RequestMethod.POST)
	public String noticeUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.noticeUpdateResult(request, path, session);
		return "redirect:noticeList";
	}
}
