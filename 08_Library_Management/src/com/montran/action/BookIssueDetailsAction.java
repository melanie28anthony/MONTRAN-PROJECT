package com.montran.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.IssueDetailsDAO;
import com.montran.pojo.IssueDetails;

public class BookIssueDetailsAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		IssueDetailsDAO dao = new IssueDetailsDAO();
		List<IssueDetails> issueDetails = dao.getAllBookIssueDetails();
		System.out.println("Total of book issue:" + issueDetails.size());
		request.setAttribute("bookIssueDetails", issueDetails);
		return mapping.findForward("success");
	}
}
