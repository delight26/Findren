package com.findren.homepage.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.findren.homepage.dao.MemberDao;
import com.findren.homepage.domain.Config;
import com.findren.homepage.domain.Member;

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
	
	@Override
	public void joinPer(Member m) {
		
		memberparam = new BeanPropertySqlParameterSource(m);
		sql = "insert into findren_hp_member (fhm_type, fhm_id, fhm_pw, fhm_name, fhm_sex, fhm_per_nation, "
				+ "fhm_per_email, fhm_per_birth, fhm_per_phone, fhm_per_cell, fhm_noauth, fhm_per_address) "
				+ "values (0, :fhm_id, :fhm_pw, :fhm_name, :fhm_sex, :fhm_per_nation, :fhm_per_email, "
				+ ":fhm_per_birth, :fhm_per_phone, :fhm_per_cell, :fhm_noauth, :fhm_per_address)";
		namedParameterJdbcTemplate.update(sql, memberparam);
	}
}
