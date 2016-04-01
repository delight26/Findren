package com.findren.homepage.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.findren.homepage.dao.NoticeDao;
import com.findren.homepage.domain.NoticeBoard;
import com.findren.homepage.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao NDao;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_GROUP = 10;

	public void setNDao(NoticeDao nDao) {
		NDao = nDao;
	}

	@Override
	public void noticeList(HttpServletRequest request) {
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.valueOf(pageNum);

		int startRow = currentPage * PAGE_SIZE - PAGE_SIZE;
		int listCount = NDao.getNoticeBoardCount();

		if (listCount > 0) {
			List<NoticeBoard> noticeList = NDao.getNoticeBoardList(startRow, PAGE_SIZE);

			int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);

			int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1
					- (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);

			int endPage = startPage + PAGE_GROUP - 1;

			if (endPage > pageCount) {
				endPage = pageCount;
			}
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("listCount", listCount);
			request.setAttribute("PAGE_GROUP", PAGE_GROUP);
		}
	}

	@Override
	public void noticeWriteResult(MultipartHttpServletRequest request, String path)
			throws IllegalStateException, IOException {
		MultipartFile multipartFile1 = request.getFile("file1");
		MultipartFile multipartFile2 = request.getFile("file2");
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String link1 = request.getParameter("link1");
		String link2 = request.getParameter("link2");

		String filename_ext1 = multipartFile1.getOriginalFilename()
				.substring(multipartFile1.getOriginalFilename().lastIndexOf(".") + 1);
		filename_ext1 = filename_ext1.toLowerCase();
		String realFileNm1 = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String today1 = formatter.format(new java.util.Date());
		realFileNm1 = today1 + UUID.randomUUID().toString()
				+ multipartFile1.getOriginalFilename().substring(multipartFile1.getOriginalFilename().lastIndexOf("."));
		String rlFileNm1 = realFileNm1;

		String filename_ext2 = multipartFile2.getOriginalFilename()
				.substring(multipartFile2.getOriginalFilename().lastIndexOf(".") + 1);
		filename_ext2 = filename_ext2.toLowerCase();
		String realFileNm2 = "";
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMddHHmmss");
		String today2 = formatter2.format(new java.util.Date());
		realFileNm2 = today2 + UUID.randomUUID().toString()
				+ multipartFile2.getOriginalFilename().substring(multipartFile2.getOriginalFilename().lastIndexOf("."));
		String rlFileNm2 = realFileNm2;

		NoticeBoard nb = new NoticeBoard();
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		
		nb.setNotice_Type(type);
		nb.setNotice_Title(title);
		nb.setNotice_Writer("admin");
		nb.setNotice_Content(content);
		nb.setNotice_WriteDate(time);
		nb.setNotice_Link1(link1);
		nb.setNotice_Link2(link2);
		
		if (!multipartFile1.isEmpty() && !multipartFile2.isEmpty()) {
			File file1 = new File(path, rlFileNm1);
			
			multipartFile1.transferTo(file1);
			File file2 = new File(path, rlFileNm2);
			multipartFile2.transferTo(file2);
			
			nb.setNotice_File1(rlFileNm1);
			nb.setNotice_File2(rlFileNm2);
			
		} else if(multipartFile1.isEmpty() && !multipartFile2.isEmpty()){
			File file2 = new File(path, rlFileNm2);
			multipartFile2.transferTo(file2);
			
			nb.setNotice_File2(rlFileNm2);
			
		} else if(!multipartFile1.isEmpty() && multipartFile2.isEmpty()){
			File file1 = new File(path, rlFileNm1);
			multipartFile1.transferTo(file1);
			
			nb.setNotice_File1(rlFileNm1);
		}
		NDao.insertNoticeBoard(nb);
	}
}
