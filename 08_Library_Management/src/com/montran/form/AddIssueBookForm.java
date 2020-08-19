package com.montran.form;

import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddIssueBookForm extends ActionForm {
	private int issueCode;
	private int bookCode;
    private	String title;
	private String author;
	private int memberCode;
	private String memberName;
	private String issueDate;
	private String returnDate;
	
	
	public int getIssueCode() {
		return issueCode;
	}
	public void setIssueCode(int issueCode) {
		this.issueCode = issueCode;
	}
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		return "AddIssueBookForm [issueCode=" + issueCode + ", bookCode=" + bookCode + ", title=" + title + ", author="
				+ author + ", memberCode=" + memberCode + ", memberName=" + memberName + ", issueDate=" + issueDate
				+ ", returnDate=" + returnDate + "]";
	}
	
}
