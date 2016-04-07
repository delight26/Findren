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

import com.findren.homepage.service.impl.NewsServiceImpl;


@Controller
public class NewsController {

	@Autowired
	private NewsServiceImpl nService;
	private static final String filePath = "/resources/file_upload/";

	public void setnService(NewsServiceImpl nService) {
		this.nService = nService;
	}
	
	//리스트
	@RequestMapping(value = "newsList")
	public String newsList(HttpServletRequest request, Model model) {
		nService.newsList(request);
		model.addAttribute("content", "News/newsList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "newsWrite")
	public String newsWrite(Model model){
		model.addAttribute("content", "News/newsWrite");
		return "home";
	}
	
	//쓰기결과
	@RequestMapping(value="newsWriteResult", method = RequestMethod.POST)
	public String newsWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.newsWriteResult(request, path, session);
		return "redirect:newsList";
	}
	
	//보기
	@RequestMapping(value="newsContent")
	public String newsContent(HttpServletRequest request,Model model){
		nService.newsContent(request);
		model.addAttribute("content", "News/newsContent");
		return "home";
	}
	
	//다음글
	@RequestMapping(value="newsNext")
	public String newsNext(HttpServletRequest request, Model model){
		nService.newsNext(request);
		model.addAttribute("content", "News/newsContent");
		
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//이전글
	@RequestMapping(value="newsPre")
	public String newsPre(HttpServletRequest request, Model model){
		nService.newsPre(request);
		model.addAttribute("content", "News/newsContent");
		
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//삭제
	@RequestMapping(value="newsDelete", method = RequestMethod.POST)
	public String newsDelete(HttpServletRequest request){
		nService.newsDelete(request);
		return "redirect:newsList";
	}
	
	//업데이트
	@RequestMapping(value="newsUpdate")
	public String newsUpdate(HttpServletRequest request, Model model){
		nService.newsUpdate(request);
		model.addAttribute("content", "News/newsUpdate");
		return "home";
	}
	
	//업데이트결과
	@RequestMapping(value="newsUpdateResult", method = RequestMethod.POST)
	public String newsUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.newsUpdateResult(request, path, session);
		return "redirect:newsList";
	}
}
