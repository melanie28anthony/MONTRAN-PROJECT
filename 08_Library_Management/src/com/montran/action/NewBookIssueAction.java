package com.montran.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.montran.dao.IssueDetailsDAO;
import com.montran.form.AddIssueBookForm;
import com.montran.pojo.Book;
import com.montran.pojo.IssueDetails;
import com.montran.pojo.Member;

public class NewBookIssueAction extends Action {
	

	

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		IssueDetailsDAO dao = new IssueDetailsDAO();
		AddIssueBookForm addIssueBookForm = (AddIssueBookForm) form;
		Member member= null;
		Book book= null;
		IssueDetails issueDetails= null;	
		ActionErrors errors = new ActionErrors();
        addIssueBookForm.setIssueCode(dao.getMaxBookIssue());
		
        
        
		if(request.getParameter("member")!= null) {
			if(request.getParameter("member").equals("getMember")) {
				System.out.println("member get is clicked");
				System.out.println(addIssueBookForm.getMemberCode());
				member= dao.getMember(addIssueBookForm.getMemberCode());
				addIssueBookForm.setMemberName(member.getMemberName());
				return mapping.findForward("book");	
			}
		}else
			errors.add("common.name.err", new ActionMessage("error.common.name.required"));
		
		
		if(request.getParameter("book")!= null) {
			if(request.getParameter("book").equals("getBook")) {
				System.out.println("book got submitted");
				System.out.println(addIssueBookForm.getBookCode());
				book= dao.getBook(addIssueBookForm.getBookCode());
				addIssueBookForm.setAuthor(book.getAuthor());
				addIssueBookForm.setTitle(book.getTitle());

				LocalDate issueDate = LocalDate.now();
				LocalDate returnDate = LocalDate.now();
				
				
				member= dao.getMember(addIssueBookForm.getMemberCode());
				addIssueBookForm.setMemberName(member.getMemberName());
				
				if(member.getMemberType().equals("S")) {
					
					returnDate = returnDate.plusDays(8);
					System.out.println(addIssueBookForm);
					}
				if(member.getMemberType().equals("F")) {
					returnDate = returnDate.plusDays(90);
					System.out.println(addIssueBookForm);
				}
				
				addIssueBookForm.setIssueDate(issueDate.toString());
				addIssueBookForm.setReturnDate(returnDate.toString());
				System.out.println("--------------------------------------");
				
				System.out.println(addIssueBookForm);
				HttpSession httpSession = request.getSession();
                httpSession.setAttribute("member", member);
				httpSession.setAttribute("book", book);
				httpSession.setAttribute("issueDate", issueDate);
				httpSession.setAttribute("returnDate", returnDate);
				return mapping.findForward("member");
				}
		}
		
		if (request.getParameter("issue") != null) {
			if (request.getParameter("issue").equals("issueBook")) {
				System.out.println("Issue Book Button Click");
				HttpSession httpSession = request.getSession();
				LocalDate issueDate = null;
				LocalDate returnDate = null;

				if (httpSession.getAttribute("book") != null)
					book = (Book) httpSession.getAttribute("book");
				if (httpSession.getAttribute("member") != null)
					member = (Member) httpSession.getAttribute("member");
				if (httpSession.getAttribute("issueDate") != null)
					issueDate = (LocalDate) httpSession.getAttribute("issueDate");
				if (httpSession.getAttribute("returnDate") != null)
					returnDate = (LocalDate) httpSession.getAttribute("returnDate");

				Random random = new Random();
				Date issueD = Date.from(issueDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date returnD = Date.from(returnDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
        issueDetails= new IssueDetails(addIssueBookForm.getIssueCode(), issueD ,returnD , book, member);
		dao.addBookIssue(issueDetails);
		System.out.println("book issued successfully");
			}
	}
		
		return mapping.findForward("success");
}
}
	
