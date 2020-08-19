package com.montran.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.IssueDetailsDAO;
import com.montran.form.AddIssueBookForm;
import com.montran.pojo.IssueDetails;

public class UpdateBookIssue extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	 IssueDetailsDAO dao= new IssueDetailsDAO();
	 AddIssueBookForm addIssueBookForm =  (AddIssueBookForm) form;
	 IssueDetails issueDetails = null;
	Boolean result= dao.updateBook(issueDetails);
	 if(result== true) {
			System.out.println("Book Updated Successfully");
		}else
			System.out.println("Book Updation Failed");
		return mapping.findForward("success");
		
	}
	 
}

