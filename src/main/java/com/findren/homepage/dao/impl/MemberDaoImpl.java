package com.findren.homepage.dao.impl;

import java.util.ArrayList;

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
				+ "values (1, :fhm_id, :fhm_pw, :fhm_name, :fhm_sex, :fhm_per_nation, :fhm_per_email, "
				+ ":fhm_per_birth, :fhm_per_phone, :fhm_per_cell, :fhm_noauth, :fhm_per_address)";
		namedParameterJdbcTemplate.update(sql, memberparam);
	}
	
	@Override
	public Member checkId(String fhm_id) {
		memberparam = new MapSqlParameterSource("fhm_id",fhm_id);
		sql = "select * from findren_hp_member where fhm_id = :fhm_id";
		return namedParameterJdbcTemplate.query(sql, memberparam, dm.getMemberRMRSE());
	}
	
	@Override
	public void joinCom(Member m) {
		memberparam = new BeanPropertySqlParameterSource(m);
		if(m.getFhm_com_part().equals("comnomal")){
			sql = "insert into findren_hp_member (fhm_type, fhm_id, fhm_pw, fhm_com_part, fhm_com_nation, "
					+ "fhm_com_name, fhm_com_logo, fhm_com_no, fhm_com_style, fhm_com_biz, fhm_com_ceo, "
					+ "fhm_com_emp, fhm_com_birth, fhm_com_homepage, fhm_com_phone, fhm_com_email, "
					+ "fhm_mailig, fhm_noauth, fhm_com_address, fhm_com_person) values(2, :fhm_id, "
					+ ":fhm_pw, :fhm_com_part, :fhm_com_nation, :fhm_com_name, :fhm_com_logo, :fhm_com_no, "
					+ ":fhm_com_style, :fhm_com_biz, :fhm_com_ceo, :fhm_com_emp, :fhm_com_birth, "
					+ ":fhm_com_homepage, :fhm_com_phone, :fhm_com_email, :fhm_mailig, :fhm_noauth, "
					+ ":fhm_com_address, :fhm_com_person);";
		} else if(m.getFhm_com_part().equals("comhead")){
			sql = "insert into findren_hp_member (fhm_type, fhm_id, fhm_pw, fhm_com_part, fhm_com_nation, "
					+ "fhm_com_name, fhm_com_logo, fhm_com_no, fhm_com_style, fhm_com_biz, fhm_com_ceo, "
					+ "fhm_com_emp, fhm_com_birth, fhm_com_homepage, fhm_com_phone, fhm_com_email, "
					+ "fhm_mailig, fhm_noauth, fhm_com_address, fhm_com_person) values(3, :fhm_id, "
					+ ":fhm_pw, :fhm_com_part, :fhm_com_nation, :fhm_com_name, :fhm_com_logo, :fhm_com_no, "
					+ ":fhm_com_style, :fhm_com_biz, :fhm_com_ceo, :fhm_com_emp, :fhm_com_birth, "
					+ ":fhm_com_homepage, :fhm_com_phone, :fhm_com_email, :fhm_mailig, :fhm_noauth, "
					+ ":fhm_com_address, :fhm_com_person);";
		} else{
			sql ="insert into findren_hp_member (fhm_type, fhm_id, fhm_pw, fhm_com_part, fhm_com_nation, "
					+ "fhm_com_name, fhm_com_logo, fhm_com_no, fhm_com_style, fhm_com_biz, fhm_com_ceo, "
					+ "fhm_com_emp, fhm_com_birth, fhm_com_homepage, fhm_com_phone, fhm_com_email, "
					+ "fhm_mailig, fhm_noauth, fhm_com_address, fhm_com_person) values(4, :fhm_id, "
					+ ":fhm_pw, :fhm_com_part, :fhm_com_nation, :fhm_com_name, :fhm_com_logo, :fhm_com_no, "
					+ ":fhm_com_style, :fhm_com_biz, :fhm_com_ceo, :fhm_com_emp, :fhm_com_birth, "
					+ ":fhm_com_homepage, :fhm_com_phone, :fhm_com_email, :fhm_mailig, :fhm_noauth, "
					+ ":fhm_com_address, :fhm_com_person);";
		}
		namedParameterJdbcTemplate.update(sql, memberparam);
	}
}
