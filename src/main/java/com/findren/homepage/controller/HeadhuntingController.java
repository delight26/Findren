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

import com.findren.homepage.service.impl.HeadhuntingServiceImpl;

@Controller
public class HeadhuntingController {

	@Autowired
	private HeadhuntingServiceImpl nService;
	private static final String filePath = "/resources/file_upload/";

	public void setnService(HeadhuntingServiceImpl nService) {
		this.nService = nService;
	}

	// 리스트
	@RequestMapping(value = "headhuntingList")
	public String headhuntingList(HttpServletRequest request, Model model) {
		nService.headhuntingList(request);
		model.addAttribute("content", "Headhunting/headhuntingList");
		return "home";
	}

	// 쓰기
	@RequestMapping(value = "headhuntingWrite")
	public String headhuntingWrite(Model model) {
		model.addAttribute("content", "Headhunting/headhuntingWrite");
		return "home";
	}

	// 쓰기결과
	@RequestMapping(value = "headhuntingWriteResult", method = RequestMethod.POST)
	public String headhuntingWriteResult(MultipartHttpServletRequest request, HttpSession session)
			throws IllegalStateException, IOException {
		String path = request.getServletContext().getRealPath(filePath);

		nService.headhuntingWriteResult(request, path, session);
		return "redirect:headhuntingList";
	}

	// 보기
	@RequestMapping(value = "headhuntingContent")
	public String headhuntingContent(HttpServletRequest request, Model model) {
		nService.headhuntingContent(request);
		return "Headhunting/headhuntingContent";
	}

	// 다음글
	@RequestMapping(value = "headhuntingnext")
	public String headhuntingNext(HttpServletRequest request, Model model) {
		nService.headhuntingNext(request);
		model.addAttribute("content", "Headhunting/headhuntingContent");

		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Headhunting/headhuntingContent";
	}

	// 이전글
	@RequestMapping(value = "headhuntingpre")
	public String headhuntingPre(HttpServletRequest request, Model model) {
		nService.headhuntingPre(request);
		model.addAttribute("content", "Headhunting/headhuntingContent");

		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "Headhunting/headhuntingContent";
	}

	// 삭제
	@RequestMapping(value = "headhuntingDelete", method = RequestMethod.POST)
	public String headhuntingDelete(HttpServletRequest request) {
		nService.headhuntingDelete(request);
		return "redirect:headhuntingList";
	}

	// 삭제
	@RequestMapping(value = "headhuntingOneDelete")
	public String headhuntingOneDelete(HttpServletRequest request) {
		nService.headhuntingDelete(request);
		return "redirect:headhuntingList";
	}

	// 업데이트
	@RequestMapping(value = "headhuntingUpdate")
	public String headhuntingUpdate(HttpServletRequest request, Model model) {
		nService.headhuntingUpdate(request);
		return "Headhunting/headhuntingUpdate";
	}

	// 업데이트결과
	@RequestMapping(value = "headhuntingUpdateResult", method = RequestMethod.POST)
	public String headhuntingUpdateResult(MultipartHttpServletRequest request, HttpSession session)
			throws IllegalStateException, IOException {
		String path = request.getServletContext().getRealPath(filePath);

		nService.headhuntingUpdateResult(request, path, session);
		return "redirect:headhuntingList";
	}
}
