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

import com.findren.homepage.service.impl.PromotionServiceImpl;


@Controller
public class PromotionController {

	@Autowired
	private PromotionServiceImpl promotionService;
	private static final String filePath = "/resources/file_upload/";

	public void setpromotionService(PromotionServiceImpl promotionService) {
		this.promotionService = promotionService;
	}
	
	//리스트
	@RequestMapping(value = "promotionList")
	public String promotionList(HttpServletRequest request, Model model) {
		promotionService.promotionList(request);
		model.addAttribute("content", "Promotion/promotionList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "promotionWrite")
	public String promotionWrite(Model model){
		model.addAttribute("content", "Promotion/promotionWrite");
		return "home";
	}
	
	//쓰기결과
	@RequestMapping(value="promotionWriteResult", method = RequestMethod.POST)
	public String promotionWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		promotionService.promotionWriteResult(request, path, session);
		return "redirect:promotionList";
	}
	
	//보기
	@RequestMapping(value="promotionContent")
	public String promotionContent(HttpServletRequest request, Model model){
		promotionService.promotionContent(request);
		model.addAttribute("content", "Promotion/promotionContent");
		return "home";
	}
	
	//다음글
	@RequestMapping(value="promotionnext")
	public String promotionNext(HttpServletRequest request, Model model){
		promotionService.promotionNext(request);
		model.addAttribute("content", "Promotion/promotionContent");
		if (request.getAttribute("promotion") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//이전글
	@RequestMapping(value="promotionpre")
	public String promotionPre(HttpServletRequest request, Model model){
		promotionService.promotionPre(request);
		model.addAttribute("content", "Promotion/promotionContent");
		if (request.getAttribute("promotion") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//삭제
	@RequestMapping(value="promotionDelete", method = RequestMethod.POST)
	public String promotionDelete(HttpServletRequest request){
		promotionService.promotionDelete(request);
		return "redirect:promotionList";
	}
	
	//업데이트
	@RequestMapping(value="promotionUpdate")
	public String promotionUpdate(HttpServletRequest request, Model model){
		model.addAttribute("content", "Promotion/promotionUpdate");
		promotionService.promotionUpdate(request);
		return "home";
	}
	
	//업데이트결과
	@RequestMapping(value="promotionUpdateResult", method = RequestMethod.POST)
	public String promotionUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		promotionService.promotionUpdateResult(request, path, session);
		return "redirect:promotionList";
	}
}
