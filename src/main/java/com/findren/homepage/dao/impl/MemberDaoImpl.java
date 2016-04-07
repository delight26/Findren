package com.findren.homepage.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.findren.homepage.dao.MemberDao;
import com.findren.homepage.domain.Config;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private SqlParameterSource memberparam;
	private String sql;
	private DaoMapper dm = new DaoMapper();
	
	@Override
	public Config perMember1() {
		memberparam = new MapSqlParameterSource("findren_config","findren_config");
		sql = "select * from findren_config";
		return namedParameterJdbcTemplate.query(sql, memberparam, dm.getConfigRMRSE());
	}
}
