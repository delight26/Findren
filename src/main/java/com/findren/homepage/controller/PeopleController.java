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

import com.findren.homepage.service.impl.PeopleServiceImpl;

@Controller
public class PeopleController {

	@Autowired
	private PeopleServiceImpl nService;
	private static final String filePath = "/resources/file_upload/";

	public void setnService(PeopleServiceImpl nService) {
		this.nService = nService;
	}

	// 리스트
	@RequestMapping(value = "peopleList")
	public String peopleList(HttpServletRequest request, Model model) {
		nService.peopleList(request);
		model.addAttribute("content", "People/peopleList");
		return "home";
	}

	// 쓰기
	@RequestMapping(value = "peopleWrite")
	public String peopleWrite(Model model) {
		model.addAttribute("content", "People/peopleWrite");
		return "home";
	}

	// 쓰기결과
	@RequestMapping(value = "peopleWriteResult", method = RequestMethod.POST)
	public String peopleWriteResult(MultipartHttpServletRequest request, HttpSession session)
			throws IllegalStateException, IOException {
		String path = request.getServletContext().getRealPath(filePath);

		nService.peopleWriteResult(request, path, session);
		return "redirect:peopleList";
	}

	// 보기
	@RequestMapping(value = "peopleContent")
	public String peopleContent(HttpServletRequest request, Model model) {
		nService.peopleContent(request);
		return "People/peopleContent";
	}

	// 다음글
	@RequestMapping(value = "peoplenext")
	public String peopleNext(HttpServletRequest request, Model model) {
		nService.peopleNext(request);
		model.addAttribute("content", "People/peopleContent");

		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "People/peopleContent";
	}

	// 이전글
	@RequestMapping(value = "peoplepre")
	public String peoplePre(HttpServletRequest request, Model model) {
		nService.peoplePre(request);
		model.addAttribute("content", "People/peopleContent");

		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "People/peopleContent";
	}

	// 삭제
	@RequestMapping(value = "peopleDelete", method = RequestMethod.POST)
	public String peopleDelete(HttpServletRequest request) {
		nService.peopleDelete(request);
		return "redirect:peopleList";
	}

	// 삭제
	@RequestMapping(value = "peopleOneDelete")
	public String peopleOneDelete(HttpServletRequest request) {
		nService.peopleDelete(request);
		return "redirect:peopleList";
	}

	// 업데이트
	@RequestMapping(value = "peopleUpdate")
	public String peopleUpdate(HttpServletRequest request, Model model) {
		nService.peopleUpdate(request);
		return "People/peopleUpdate";
	}

	// 업데이트결과
	@RequestMapping(value = "peopleUpdateResult", method = RequestMethod.POST)
	public String peopleUpdateResult(MultipartHttpServletRequest request, HttpSession session)
			throws IllegalStateException, IOException {
		String path = request.getServletContext().getRealPath(filePath);

		nService.peopleUpdateResult(request, path, session);
		return "redirect:peopleList";
	}
}
