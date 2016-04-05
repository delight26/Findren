package com.findren.homepage.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findren.homepage.dao.MemberDao;
import com.findren.homepage.domain.Config;
import com.findren.homepage.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao mDao;
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_GROUP = 10;

	public void setmDao(MemberDao mDao) {
		this.mDao = mDao;
	}
	
	@Override
	public void perMember1(HttpServletRequest request) {
		Config cf = mDao.perMember1();
		
		request.setAttribute("cf", cf);
	}
	
	@Override
	public void joinPer(HttpServletRequest request) {
		
	}
}
