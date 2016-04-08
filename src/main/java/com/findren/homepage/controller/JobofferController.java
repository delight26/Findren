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

import com.findren.homepage.service.impl.JobofferServiceImpl;

@Controller
public class JobofferController {

	@Autowired
	private JobofferServiceImpl jobService;
	private static final String filePath = "/resources/file_upload/";

	public void setjobService(JobofferServiceImpl jobService) {
		this.jobService = jobService;
	}

	//리스트
	@RequestMapping(value = "jobofferList")
	public String jobofferList(HttpServletRequest request, Model model) {
		jobService.jobofferList(request);
		model.addAttribute("content", "JobOffer/jobofferList");
		return "home";
	}
	
	//쓰기
	@RequestMapping(value = "jobofferWrite")
	public String jobofferWrite(Model model){
		model.addAttribute("content", "JobOffer/jobofferWrite" );
		return "home";
	}
	
	//쓰기결과
	@RequestMapping(value="jobofferWriteResult", method = RequestMethod.POST)
	public String jobofferWriteResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		jobService.jobofferWriteResult(request, path, session);
		return "redirect:jobofferList";
	}
	
	//보기
	@RequestMapping(value="jobofferContent")
	public String jobofferContent(HttpServletRequest request, Model model){
		jobService.jobofferContent(request);
		model.addAttribute("content", "JobOffer/jobofferContent");
		return "home";
	}
	
	//다음글
	@RequestMapping(value="joboffernext")
	public String jobofferNext(HttpServletRequest request, Model model){
		jobService.jobofferNext(request);
		model.addAttribute("content", "JobOffer/jobofferConetent");
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "마지막 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//이전글
	@RequestMapping(value="jobofferpre")
	public String jobofferPre(HttpServletRequest request, Model model){
		jobService.jobofferPre(request);
		model.addAttribute("content", "JobOffer/jobofferConetent");
		if (request.getAttribute("nb") == null) {
			request.setAttribute("message", "최신 글 입니다.");
			request.setAttribute("returnUrl", "javascript:history.back()");
			return "alertAndRedirect";
		}
		return "home";
	}
	
	//삭제
	@RequestMapping(value="jobofferDelete", method = RequestMethod.POST)
	public String jobofferDelete(HttpServletRequest request){
		jobService.jobofferDelete(request);
		return "redirect:jobofferList";
	}
	
	//업데이트
	@RequestMapping(value="jobofferUpdate")
	public String jobofferUpdate(HttpServletRequest request, Model model){
		jobService.jobofferUpdate(request);
		model.addAttribute("content", "JobOffer/jobofferUpdate");
		return "home";
	}
	
	//업데이트결과
	@RequestMapping(value="jobofferUpdateResult", method = RequestMethod.POST)
	public String jobofferUpdateResult(MultipartHttpServletRequest request, HttpSession session) throws IllegalStateException, IOException{
		String path = request.getServletContext().getRealPath(filePath);
		
		jobService.jobofferUpdateResult(request, path, session);
		return "redirect:jobofferList";
	}
}
