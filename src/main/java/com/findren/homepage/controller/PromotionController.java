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
	private PromotionServiceImpl nService;
	private static final String filePath = "/resources/file_upload/";

	public void setnService(PromotionServiceImpl nService) {
		this.nService = nService;
	}
	
	//리스트
	@RequestMapping(value = "promotionList")
	public String promotionList(HttpServletRequest request, Model model) {
		nService.promotionList(request);
		model.addAttribute("content", "Promotion/promotionList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "promotionWrite")
	public String promotionWrite(){
		return "Promotion/promotionWrite";
	}
	
	//쓰기결과
	@RequestMapping(value="promotionWriteResult", method = RequestMethod.POST)
	public String promotionWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.promotionWriteResult(request, path, session);
		return "redirect:promotionList";
	}
	
	//보기
	@RequestMapping(value="promotionContent")
	public String promotionContent(HttpServletRequest request){
		nService.promotionContent(request);
		return "Promotion/promotionContent";
	}
	
	//다음글
	@RequestMapping(value="promotionnext")
	public String promotionNext(HttpServletRequest request){
		nService.promotionNext(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Promotion/promotionContent";
	}
	
	//이전글
	@RequestMapping(value="promotionpre")
	public String promotionPre(HttpServletRequest request){
		nService.promotionPre(request);
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Promotion/promotionContent";
	}
	
	//삭제
	@RequestMapping(value="promotionDelete", method = RequestMethod.POST)
	public String promotionDelete(HttpServletRequest request){
		nService.promotionDelete(request);
		return "redirect:promotionList";
	}
	
	//업데이트
	@RequestMapping(value="promotionUpdate")
	public String promotionUpdate(HttpServletRequest request){
		nService.promotionUpdate(request);
		return "Promotion/promotionUpdate";
	}
	
	//업데이트결과
	@RequestMapping(value="promotionUpdateResult", method = RequestMethod.POST)
	public String promotionUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		nService.promotionUpdateResult(request, path, session);
		return "redirect:promotionList";
	}
}
