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

import com.findren.homepage.dao.WechatpayDao;
import com.findren.homepage.domain.WechatpayBoard;
import com.findren.homepage.service.WechatpayService;

@Service
public class WechatpayImpl implements WechatpayService {

	@Autowired
	private WechatpayDao NDao;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_GROUP = 10;

	public void setNDao(WechatpayDao nDao) {
		NDao = nDao;
	}

	@Override
	public void wechatpayList(HttpServletRequest request) {
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.valueOf(pageNum);

		int startRow = currentPage * PAGE_SIZE - PAGE_SIZE;
		int listCount = NDao.getWechatpayBoardCount();

		if (listCount > 0) {
			List<WechatpayBoard> wechatpayList = NDao.getWechatpayBoardList(startRow, PAGE_SIZE);

			int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);

			int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1
					- (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);

			int endPage = startPage + PAGE_GROUP - 1;

			if (endPage > pageCount) {
				endPage = pageCount;
			}
			request.setAttribute("wechatpayList", wechatpayList);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("listCount", listCount);
			request.setAttribute("PAGE_GROUP", PAGE_GROUP);
		}
	}

	@Override
	public void wechatpayWriteResult(MultipartHttpServletRequest request, String path, HttpSession session)
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

		WechatpayBoard nb = new WechatpayBoard();

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

		nb.setWr_subject(title);
		nb.setWr_content(content);
		nb.setMb_id("admin");
		nb.setWr_name("중국인찾기");
		nb.setWr_link1(link1);
		nb.setWr_link2(link2);
		nb.setWr_datetime(time);
		nb.setWr_ip(wr_ip);
		nb.setWr_option(type);

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

			nb.setWr_file1(rlFileNm1);
			nb.setWr_file2(rlFileNm2);

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

			nb.setWr_file1("");
			nb.setWr_file2(rlFileNm2);

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

			nb.setWr_file1(rlFileNm1);
			nb.setWr_file2("");
		}
		NDao.insertWechatpayBoard(nb);
	}

	@Override
	public void wechatpayContent(HttpServletRequest request) {
		int no = Integer.valueOf(request.getParameter("no"));
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		int watch = Integer.valueOf(request.getParameter("watch"));

		NDao.wechatpayWatchUpdate(watch + 1, no);
		WechatpayBoard nb = NDao.wechatpayContent(no);
		request.setAttribute("nb", nb);
		request.setAttribute("pageNum", pageNum);
	}

	@Override
	public void wechatpayNext(HttpServletRequest request) {
		int no = Integer.valueOf(request.getParameter("no"));
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		Integer nextNo = NDao.wechatpayNextNo(no);
		if (nextNo == null) {

		} else {
			WechatpayBoard nb = NDao.wechatpayContent(nextNo);
			NDao.wechatpayWatchUpdate(nb.getWr_hit() + 1, nextNo);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("nb", nb);
		}
	}

	@Override
	public void wechatpayPre(HttpServletRequest request) {
		int no = Integer.valueOf(request.getParameter("no"));
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		Integer nextNo = NDao.wechatpayPreNo(no);
		if (nextNo == null) {

		} else {
			WechatpayBoard nb = NDao.wechatpayContent(nextNo);
			NDao.wechatpayWatchUpdate(nb.getWr_hit() + 1, nextNo);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("nb", nb);
		}
	}

	@Override
	public void wechatpayDelete(HttpServletRequest request) {
		String[] check = request.getParameterValues("check");
		for (int i = 0; i < check.length; i++) {
			NDao.wechatpayDelete(Integer.parseInt(check[i]));
		}
	}

	@Override
	public void wechatpayUpdate(HttpServletRequest request) {
		int no = Integer.valueOf(request.getParameter("no"));

		WechatpayBoard nb = NDao.wechatpayContent(no);

		request.setAttribute("nb", nb);
	}

	@Override
	public void wechatpayUpdateResult(MultipartHttpServletRequest request, String path, HttpSession session)
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

		WechatpayBoard nb = new WechatpayBoard();

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

		nb.setWr_id(no);
		nb.setWr_subject(title);
		nb.setWr_content(content);
		nb.setMb_id("admin");
		nb.setWr_name("중국인찾기");
		nb.setWr_link1(link1);
		nb.setWr_link2(link2);
		nb.setWr_datetime(time);
		nb.setWr_ip(wr_ip);
		nb.setWr_option(type);

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

			nb.setWr_file1(rlFileNm1);
			nb.setWr_file2(rlFileNm2);

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

			nb.setWr_file1("");
			nb.setWr_file2(rlFileNm2);

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

			nb.setWr_file1(rlFileNm1);
			nb.setWr_file2("");
		}
		NDao.updateWechatpayBoard(nb);

	}
}