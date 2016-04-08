package com.findren.homepage.dao;

import com.findren.homepage.domain.Config;
import com.findren.homepage.domain.Member;

public interface MemberDao {
	
	public Config perMember1();
	
	public void joinPer(Member m);
}
