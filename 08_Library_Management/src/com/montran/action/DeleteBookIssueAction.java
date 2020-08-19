package com.montran.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.IssueDetailsDAO;
import com.montran.form.AddIssueBookForm;


public class DeleteBookIssueAction extends Action {
 @Override
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	 System.out.println("In DeleteBookAction execute()");
	 IssueDetailsDAO dao= new IssueDetailsDAO();
	 AddIssueBookForm addIssueBookForm=  (AddIssueBookForm) form;
	 int issueCode = addIssueBookForm.getIssueCode();
	 System.out.println("Book Deleted Successfully");
		
		return mapping.findForward("success");
	}
}