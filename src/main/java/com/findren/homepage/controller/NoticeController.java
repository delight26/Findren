package com.findren.homepage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.findren.homepage.service.impl.NoticeServiceImpl;

@Controller
public class NoticeController {

	@Autowired
	private NoticeServiceImpl nService;

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
}
