package com.findren.homepage.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.findren.homepage.dao.HeadhuntingDao;
import com.findren.homepage.domain.HeadhuntingBoard;
import com.findren.homepage.service.HeadhuntingService;

@Service
public class HeadhuntingServiceImpl implements HeadhuntingService {

	@Autowired
	private HeadhuntingDao HeadhuntingDao;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_GROUP = 10;

	public void setHeadhuntingDao(HeadhuntingDao headhuntingDao) {
		HeadhuntingDao = headhuntingDao;
	}

	@Override
	public void headhuntingList(HttpServletRequest request) {
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.valueOf(pageNum);

		int startRow = currentPage * PAGE_SIZE - PAGE_SIZE;
		int listCount = HeadhuntingDao.getHeadhuntingBoardCount();

		if (listCount > 0) {
			List<HeadhuntingBoard> headhuntingList = HeadhuntingDao.getHeadhuntingBoardList(startRow, PAGE_SIZE);

			int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);

			int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1
					- (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);

			int endPage = startPage + PAGE_GROUP - 1;

			if (endPage > pageCount) {
				endPage = pageCount;
			}
			request.setAttribute("headhuntingList", headhuntingList);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("listCount", listCount);
			request.setAttribute("PAGE_GROUP", PAGE_GROUP);
		}
	}

	@Override
	public void headhuntingWriteResult(MultipartHttpServletRequest request, String path, HttpSession session)
			throws IllegalStateException, IOException {
		request.setCharacterEncoding("utf-8");
		MultipartFile multipartFile1 = request.getFile("file1");
		MultipartFile multipartFile2 = request.getFile("file2");
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String link1 = request.getParameter("link1");
		String link2 = request.getParameter("link2");

		if (!link1.isEmpty() && link1.substring(0, 7).equals("http://")) {
			link1 = link1.substring(7);
		}

		if (!link2.isEmpty() && link2.substring(0, 7).equals("http://")) {
			link2 = link2.substring(7);
		}

		if (type == null) {
			type = "normal";
		}

		HeadhuntingBoard headhunting = new HeadhuntingBoard();

		Timestamp time = new Timestamp(System.currentTimeMillis());

		String wr_ip = request.getHeader("X-FORWARDED-FOR");

		if (wr_ip == null || wr_ip.length() == 0) {
			wr_ip = request.getHeader("Proxy-Client-IP");
		}

		if (wr_ip == null || wr_ip.length() == 0) {
			wr_ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
		}

		if (wr_ip == null || wr_ip.length() == 0) {
			wr_ip = request.getRemoteAddr();
		}

		headhunting.setWr_subject(title);
		headhunting.setWr_content(content);
		headhunting.setMb_id("admin");
		headhunting.setWr_name("중국인찾기");
		headhunting.setWr_link1(link1);
		headhunting.setWr_link2(link2);
		headhunting.setWr_datetime(time);
		headhunting.setWr_ip(wr_ip);
		headhunting.setWr_option(type);

		if (!multipartFile1.isEmpty() && !multipartFile2.isEmpty()) {
			String filename_ext1 = multipartFile1.getOriginalFilename()
					.substring(multipartFile1.getOriginalFilename().lastIndexOf(".") + 1);
			filename_ext1 = filename_ext1.toLowerCase();
			String realFileNm1 = "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String today1 = formatter.format(new java.util.Date());
			realFileNm1 = today1 + UUID.randomUUID().toString() + multipartFile1.getOriginalFilename()
					.substring(multipartFile1.getOriginalFilename().lastIndexOf("."));
			String rlFileNm1 = realFileNm1;
			File file1 = new File(path, rlFileNm1);
			multipartFile1.transferTo(file1);

			String filename_ext2 = multipartFile2.getOriginalFilename()
					.substring(multipartFile2.getOriginalFilename().lastIndexOf(".") + 1);
			filename_ext2 = filename_ext2.toLowerCase();
			String realFileNm2 = "";
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String today2 = formatter2.format(new java.util.Date());
			realFileNm2 = today2 + UUID.randomUUID().toString() + multipartFile2.getOriginalFilename()
					.substring(multipartFile2.getOriginalFilename().lastIndexOf("."));
			String rlFileNm2 = realFileNm2;
			File file2 = new File(path, rlFileNm2);
			multipartFile2.transferTo(file2);

			headhunting.setWr_file1(rlFileNm1);
			headhunting.setWr_file2(rlFileNm2);

		} else if (multipartFile1.isEmpty() && !multipartFile2.isEmpty()) {
			String filename_ext2 = multipartFile2.getOriginalFilename()
					.substring(multipartFile2.getOriginalFilename().lastIndexOf(".") + 1);
			filename_ext2 = filename_ext2.toLowerCase();
			String realFileNm2 = "";
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String today2 = formatter2.format(new java.util.Date());
			realFileNm2 = today2 + UUID.randomUUID().toString() + multipartFile2.getOriginalFilename()
					.substring(multipartFile2.getOriginalFilename().lastIndexOf("."));
			String rlFileNm2 = realFileNm2;
			File file2 = new File(path, rlFileNm2);
			multipartFile2.transferTo(file2);

			headhunting.setWr_file1("");
			headhunting.setWr_file2(rlFileNm2);

		} else if (!multipartFile1.isEmpty() && multipartFile2.isEmpty()) {
			String filename_ext1 = multipartFile1.getOriginalFilename()
					.substring(multipartFile1.getOriginalFilename().lastIndexOf(".") + 1);
			filename_ext1 = filename_ext1.toLowerCase();
			String realFileNm1 = "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String today1 = formatter.format(new java.util.Date());
			realFileNm1 = today1 + UUID.randomUUID().toString() + multipartFile1.getOriginalFilename()
					.substring(multipartFile1.getOriginalFilename().lastIndexOf("."));
			String rlFileNm1 = realFileNm1;
			File file1 = new File(path, rlFileNm1);
			multipartFile1.transferTo(file1);

			headhunting.setWr_file1(rlFileNm1);
			headhunting.setWr_file2("");
		}
		HeadhuntingDao.insertHeadhuntingBoard(headhunting);
	}

	@Override
	public void headhuntingContent(HttpServletRequest request) {
		int no = Integer.valueOf(request.getParameter("no"));
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		int watch = Integer.valueOf(request.getParameter("watch"));

		HeadhuntingDao.headhuntingWatchUpdate(watch + 1, no);
		HeadhuntingBoard headhunting = HeadhuntingDao.headhuntingContent(no);
		request.setAttribute("headhunting", headhunting);
		request.setAttribute("pageNum", pageNum);
	}

	@Override
	public void headhuntingNext(HttpServletRequest request) {
		int no = Integer.valueOf(request.getParameter("no"));
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		Integer nextNo = HeadhuntingDao.headhuntingNextNo(no);
		if (nextNo == null) {

		} else {
			HeadhuntingBoard headhunting = HeadhuntingDao.headhuntingContent(nextNo);
			HeadhuntingDao.headhuntingWatchUpdate(headhunting.getWr_hit() + 1, nextNo);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("headhunting", headhunting);
		}
	}

	@Override
	public void headhuntingPre(HttpServletRequest request) {
		int no = Integer.valueOf(request.getParameter("no"));
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		Integer nextNo = HeadhuntingDao.headhuntingPreNo(no);
		if (nextNo == null) {

		} else {
			HeadhuntingBoard headhunting = HeadhuntingDao.headhuntingContent(nextNo);
			HeadhuntingDao.headhuntingWatchUpdate(headhunting.getWr_hit() + 1, nextNo);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("headhunting", headhunting);
		}
	}

	@Override
	public void headhuntingDelete(HttpServletRequest request) {
		String no = request.getParameter("no");
		String[] check = request.getParameterValues("check");
		if(check == null){
			HeadhuntingDao.headhuntingDelete(Integer.valueOf(no));
		} else{
			for (int i = 0; i < check.length; i++) {
				HeadhuntingDao.headhuntingDelete(Integer.parseInt(check[i]));
			}
		}
	}

	@Override
	public void headhuntingUpdate(HttpServletRequest request) {
		int no = Integer.valueOf(request.getParameter("no"));

		HeadhuntingBoard headhunting = HeadhuntingDao.headhuntingContent(no);

		request.setAttribute("headhunting", headhunting);
	}

	@Override
	public void headhuntingUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session)
			throws IllegalStateException, IOException {
		request.setCharacterEncoding("utf-8");
		MultipartFile multipartFile1 = request.getFile("file1");
		MultipartFile multipartFile2 = request.getFile("file2");
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String link1 = request.getParameter("link1");
		String link2 = request.getParameter("link2");
		int no = Integer.valueOf(request.getParameter("no"));

		if (!link1.isEmpty() && link1.substring(0, 7).equals("http://")) {
			link1 = link1.substring(7);
		}

		if (!link2.isEmpty() && link2.substring(0, 7).equals("http://")) {
			link2 = link2.substring(7);
		}

		if (type == null) {
			type = "normal";
		}

		HeadhuntingBoard headhunting = new HeadhuntingBoard();

		Timestamp time = new Timestamp(System.currentTimeMillis());

		String wr_ip = request.getHeader("X-FORWARDED-FOR");

		if (wr_ip == null || wr_ip.length() == 0) {
			wr_ip = request.getHeader("Proxy-Client-IP");
		}

		if (wr_ip == null || wr_ip.length() == 0) {
			wr_ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
		}

		if (wr_ip == null || wr_ip.length() == 0) {
			wr_ip = request.getRemoteAddr();
		}

		headhunting.setWr_id(no);
		headhunting.setWr_subject(title);
		headhunting.setWr_content(content);
		headhunting.setMb_id("admin");
		headhunting.setWr_name("중국인찾기");
		headhunting.setWr_link1(link1);
		headhunting.setWr_link2(link2);
		headhunting.setWr_datetime(time);
		headhunting.setWr_ip(wr_ip);
		headhunting.setWr_option(type);

		if (!multipartFile1.isEmpty() && !multipartFile2.isEmpty()) {
			String filename_ext1 = multipartFile1.getOriginalFilename()
					.substring(multipartFile1.getOriginalFilename().lastIndexOf(".") + 1);
			filename_ext1 = filename_ext1.toLowerCase();
			String realFileNm1 = "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String today1 = formatter.format(new java.util.Date());
			realFileNm1 = today1 + UUID.randomUUID().toString() + multipartFile1.getOriginalFilename()
					.substring(multipartFile1.getOriginalFilename().lastIndexOf("."));
			String rlFileNm1 = realFileNm1;
			File file1 = new File(path, rlFileNm1);
			multipartFile1.transferTo(file1);

			String filename_ext2 = multipartFile2.getOriginalFilename()
					.substring(multipartFile2.getOriginalFilename().lastIndexOf(".") + 1);
			filename_ext2 = filename_ext2.toLowerCase();
			String realFileNm2 = "";
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String today2 = formatter2.format(new java.util.Date());
			realFileNm2 = today2 + UUID.randomUUID().toString() + multipartFile2.getOriginalFilename()
					.substring(multipartFile2.getOriginalFilename().lastIndexOf("."));
			String rlFileNm2 = realFileNm2;
			File file2 = new File(path, rlFileNm2);
			multipartFile2.transferTo(file2);

			headhunting.setWr_file1(rlFileNm1);
			headhunting.setWr_file2(rlFileNm2);

		} else if (multipartFile1.isEmpty() && !multipartFile2.isEmpty()) {
			String filename_ext2 = multipartFile2.getOriginalFilename()
					.substring(multipartFile2.getOriginalFilename().lastIndexOf(".") + 1);
			filename_ext2 = filename_ext2.toLowerCase();
			String realFileNm2 = "";
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String today2 = formatter2.format(new java.util.Date());
			realFileNm2 = today2 + UUID.randomUUID().toString() + multipartFile2.getOriginalFilename()
					.substring(multipartFile2.getOriginalFilename().lastIndexOf("."));
			String rlFileNm2 = realFileNm2;
			File file2 = new File(path, rlFileNm2);
			multipartFile2.transferTo(file2);

			headhunting.setWr_file1("");
			headhunting.setWr_file2(rlFileNm2);

		} else if (!multipartFile1.isEmpty() && multipartFile2.isEmpty()) {
			String filename_ext1 = multipartFile1.getOriginalFilename()
					.substring(multipartFile1.getOriginalFilename().lastIndexOf(".") + 1);
			filename_ext1 = filename_ext1.toLowerCase();
			String realFileNm1 = "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String today1 = formatter.format(new java.util.Date());
			realFileNm1 = today1 + UUID.randomUUID().toString() + multipartFile1.getOriginalFilename()
					.substring(multipartFile1.getOriginalFilename().lastIndexOf("."));
			String rlFileNm1 = realFileNm1;
			File file1 = new File(path, rlFileNm1);
			multipartFile1.transferTo(file1);

			headhunting.setWr_file1(rlFileNm1);
			headhunting.setWr_file2("");
		}
		HeadhuntingDao.updateHeadhuntingBoard(headhunting);

	}
}
