package com.findren.homepage.domain;

import java.sql.Timestamp;

public class NoticeBoard {
	private int notice_No;
	private String notice_Type;
	private String notice_Title;
	private String notice_Writer;
	private String notice_Content;
	private Timestamp notice_WriteDate;
	private int notice_Watch;
	private String notice_Link1;
	private String notice_Link2;
	private String notice_File1;
	private String notice_File2;
	
	public int getNotice_No() {
		return notice_No;
	}
	public void setNotice_No(int notice_No) {
		this.notice_No = notice_No;
	}
	public String getNotice_Type() {
		return notice_Type;
	}
	public void setNotice_Type(String notice_Type) {
		this.notice_Type = notice_Type;
	}
	public String getNotice_Title() {
		return notice_Title;
	}
	public void setNotice_Title(String notice_Title) {
		this.notice_Title = notice_Title;
	}
	public String getNotice_Writer() {
		return notice_Writer;
	}
	public void setNotice_Writer(String notice_Writer) {
		this.notice_Writer = notice_Writer;
	}
	public String getNotice_Content() {
		return notice_Content;
	}
	public void setNotice_Content(String notice_Content) {
		this.notice_Content = notice_Content;
	}
	public Timestamp getNotice_WriteDate() {
		return notice_WriteDate;
	}
	public void setNotice_WriteDate(Timestamp notice_WriteDate) {
		this.notice_WriteDate = notice_WriteDate;
	}
	public int getNotice_Watch() {
		return notice_Watch;
	}
	public void setNotice_Watch(int notice_Watch) {
		this.notice_Watch = notice_Watch;
	}
	public String getNotice_Link1() {
		return notice_Link1;
	}
	public void setNotice_Link1(String notice_Link1) {
		this.notice_Link1 = notice_Link1;
	}
	public String getNotice_Link2() {
		return notice_Link2;
	}
	public void setNotice_Link2(String notice_Link2) {
		this.notice_Link2 = notice_Link2;
	}
	public String getNotice_File1() {
		return notice_File1;
	}
	public void setNotice_File1(String notice_File1) {
		this.notice_File1 = notice_File1;
	}
	public String getNotice_File2() {
		return notice_File2;
	}
	public void setNotice_File2(String notice_File2) {
		this.notice_File2 = notice_File2;
	}
}
