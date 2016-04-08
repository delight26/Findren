package com.findren.homepage.domain;

import java.sql.Timestamp;

public class PeopleBoard {
	private int wr_id;
	private String wr_subject;
	private String wr_content;
	private String mb_id;
	private String wr_name;
	private String wr_link1;
	private String wr_link2;
	private int wr_link1_hit;
	private int wr_link2_hit;
	private int wr_hit;
	private Timestamp wr_datetime;
	private String wr_file1;
	private String wr_file2;
	private String wr_ip;
	private String wr_option;
	
	public int getWr_id() {
		return wr_id;
	}
	public void setWr_id(int wr_id) {
		this.wr_id = wr_id;
	}
	public String getWr_subject() {
		return wr_subject;
	}
	public void setWr_subject(String wr_subject) {
		this.wr_subject = wr_subject;
	}
	public String getWr_content() {
		return wr_content;
	}
	public void setWr_content(String wr_content) {
		this.wr_content = wr_content;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getWr_name() {
		return wr_name;
	}
	public void setWr_name(String wr_name) {
		this.wr_name = wr_name;
	}
	public String getWr_link1() {
		return wr_link1;
	}
	public void setWr_link1(String wr_link1) {
		this.wr_link1 = wr_link1;
	}
	public String getWr_link2() {
		return wr_link2;
	}
	public void setWr_link2(String wr_link2) {
		this.wr_link2 = wr_link2;
	}
	public int getWr_link1_hit() {
		return wr_link1_hit;
	}
	public void setWr_link1_hit(int wr_link1_hit) {
		this.wr_link1_hit = wr_link1_hit;
	}
	public int getWr_link2_hit() {
		return wr_link2_hit;
	}
	public void setWr_link2_hit(int wr_link2_hit) {
		this.wr_link2_hit = wr_link2_hit;
	}
	public int getWr_hit() {
		return wr_hit;
	}
	public void setWr_hit(int wr_hit) {
		this.wr_hit = wr_hit;
	}
	public Timestamp getWr_datetime() {
		return wr_datetime;
	}
	public void setWr_datetime(Timestamp wr_datetime) {
		this.wr_datetime = wr_datetime;
	}
	public String getWr_file1() {
		return wr_file1;
	}
	public void setWr_file1(String wr_file1) {
		this.wr_file1 = wr_file1;
	}
	public String getWr_file2() {
		return wr_file2;
	}
	public void setWr_file2(String wr_file2) {
		this.wr_file2 = wr_file2;
	}
	public String getWr_ip() {
		return wr_ip;
	}
	public void setWr_ip(String wr_ip) {
		this.wr_ip = wr_ip;
	}
	public String getWr_option() {
		return wr_option;
	}
	public void setWr_option(String wr_option) {
		this.wr_option = wr_option;
	}
}