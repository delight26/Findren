package com.findren.homepage.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.findren.homepage.dao.PeopleDao;
import com.findren.homepage.domain.PeopleBoard;

@Repository
public class PeopleDaoImpl implements PeopleDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	private SqlParameterSource peopleparam;
	private String sql;
	private DaoMapper dm = new DaoMapper();

	@Override
	public Integer getPeopleBoardCount() 
	{
		peopleparam = new MapSqlParameterSource("findren_write_12_board", "findren_write_12_board");
		sql = "select count(*) from findren_write_12_board";
		return namedParameterJdbcTemplate.queryForObject(sql, peopleparam, Integer.class);
	}

	@Override
	public List<PeopleBoard> getPeopleBoardList(int startRow, int PAGE_SIZE) 
	{
		peopleparam = new MapSqlParameterSource("startRow", startRow).addValue("PAGE_SIZE",
				PAGE_SIZE);
		sql = "select * from findren_write_12_board order by wr_datetime desc limit :startRow, :PAGE_SIZE";
		return namedParameterJdbcTemplate.query(sql, peopleparam, dm.getPeopleBoardRMRSE());
	}

	@Override
	public void insertPeopleBoard(PeopleBoard nb) {
		peopleparam = new BeanPropertySqlParameterSource(nb);
		sql = "insert into findren_write_12_board (wr_id, wr_subject, wr_content, mb_id, wr_name, wr_link1, wr_link2, wr_link1_hit, wr_link2_hit,"
				+ "wr_hit, wr_datetime, wr_file1, wr_file2, wr_ip, wr_option) "
				+ "values(0, :wr_subject, :wr_content, :mb_id, :wr_name, :wr_link1, :wr_link2, 0, 0,"
				+ "0, :wr_datetime, :wr_file1, :wr_file2, :wr_ip, :wr_option)";
		namedParameterJdbcTemplate.update(sql, peopleparam);
	}
	
	@Override
	public void peopleWatchUpdate(int watch, int no) {
		peopleparam = new MapSqlParameterSource("watch", watch).addValue("no", no);
		sql = "update findren_write_12_board set wr_hit = :watch where wr_id = :no";
		namedParameterJdbcTemplate.update(sql, peopleparam);
		
	}
	
	@Override
	public PeopleBoard peopleContent(int no) {
		peopleparam = new MapSqlParameterSource("no", no);
		sql = "select * from findren_write_12_board where wr_id = :no";
		return namedParameterJdbcTemplate.query(sql, peopleparam, dm.getPeopleBoardRMRSE());
	}
	
	@Override
	public Integer peopleNextNo(int no) {
		peopleparam = new MapSqlParameterSource("no", no);
		sql = "SELECT max(wr_id) FROM findren_write_12_board nb WHERE wr_id < :no;";
		return namedParameterJdbcTemplate.queryForObject(
				sql, peopleparam, Integer.class);
	}
	
	@Override
	public Integer peoplePreNo(int no) {
		peopleparam = new MapSqlParameterSource("no", no);
		sql = "SELECT min(wr_id) FROM findren_write_12_board nb WHERE wr_id > :no;";
		return namedParameterJdbcTemplate.queryForObject(
				sql, peopleparam, Integer.class);
	}
	
	@Override
	public void peopleDelete(int no) {
		peopleparam = new MapSqlParameterSource("no", no);
		sql = "delete from findren_write_12_board where wr_id = :no";
		namedParameterJdbcTemplate.update(sql, peopleparam);
	}
	
	@Override
	public void updatePeopleBoard(PeopleBoard nb) {
		peopleparam = new BeanPropertySqlParameterSource(nb);
		if(!nb.getWr_file1().isEmpty() && !nb.getWr_file2().isEmpty()){
			sql = "update findren_write_12_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
				+ "wr_datetime = :wr_datetime, wr_file1 = :wr_file1, wr_file2 = :wr_file2, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		} else if(!nb.getWr_file1().isEmpty() && nb.getWr_file2().isEmpty()){
			sql = "update findren_write_12_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
					+ "wr_datetime = :wr_datetime, wr_file1 = :wr_file1, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		} else if(nb.getWr_file1().isEmpty() && !nb.getWr_file2().isEmpty()){
			sql = "update findren_write_12_board set wr_subject = :wr_subject, wr_content = :wr_content, wr_link1 = :wr_link1, wr_link2 = :wr_link2,"
					+ "wr_datetime = :wr_datetime, wr_file2 = :wr_file2, wr_ip = :wr_ip, wr_option = :wr_option where wr_id = :wr_id";
		}
		namedParameterJdbcTemplate.update(sql, peopleparam);
	}
	
	@Override
	public Integer maxNum() {
		peopleparam = new MapSqlParameterSource("findren_write_12_board", "findren_write_12_board");
		sql = "select max(wr_num) from findren_write_12_board";
		return namedParameterJdbcTemplate.queryForObject(sql, peopleparam, Integer.class);
	}
}
