package com.montran.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.montran.form.AddIssueBookForm;
import com.montran.pojo.Book;
import com.montran.pojo.IssueDetails;
import com.montran.pojo.Member;
import com.montran.util.SessionFactoryUtil;

public class IssueDetailsDAO {
	private Session session;
	private Transaction transaction;
	private int issueSerialNumber;

	public List<IssueDetails> getAllBookIssueDetails() {
		session = SessionFactoryUtil.getFactory().openSession();
		Query query = session.createQuery("from book_issue");
		List<IssueDetails> bookIssueList = query.getResultList();
		System.out.println(bookIssueList.size());
		session.close();
		return bookIssueList;
	}
	
	public void addBookIssue(IssueDetails issueDetails) {

		session = SessionFactoryUtil.getFactory().openSession();
		transaction = session.beginTransaction();
		session.save(issueDetails);
		transaction.commit();
		session.close();
	}
	
   public Book getBook(int bookCode) {
	   session = SessionFactoryUtil.getFactory().openSession();
	   Book book = new Book();
	   book= session.get(Book.class, bookCode);
	   session.close();
	  return book;
   }
	
   public Member getMember(int memberCode) {
	   session = SessionFactoryUtil.getFactory().openSession();
		Member member = new Member();
		member = session.get(Member.class, memberCode);
		session.close();
		return member;
	} 
   public boolean updateBook(IssueDetails issueDetails) {
		if (SessionFactoryUtil.getFactory()!= null) {
			session = SessionFactoryUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			session.update(issueDetails); 
			transaction.commit();
			session.close();
			return true;
		} else {
			return false;
		}
	} 
  
   public int getMaxBookIssue() {
		session = SessionFactoryUtil.getFactory().openSession();
		Query query = session.createQuery("select max(issueCode) from book_issue");
		List<Integer> issueList = query.list();
		int maxCount = issueList.get(0);
		System.out.println("Total Books :: " + maxCount);
		session.close();
        return maxCount + 1;
	}
   
   public int getBookRecord(int bookCode) {
	   session = SessionFactoryUtil.getFactory().openSession();
		Query query = session.createQuery("from Book_issue where book_code=:code");
		query.setParameter("code", bookCode);
		IssueDetails issueDetails = (IssueDetails) query.uniqueResult();
		if (issueDetails != null) {
			return issueDetails.getMember().getMemberCode();
		}
		return 0;
	}
   
   public void updateMemberDetails(int memberCode) {
	    session = SessionFactoryUtil.getFactory().openSession();
		transaction = session.beginTransaction();
		Member member = session.load(Member.class, memberCode);
		member.setNumberOfCopiesIssued("member.getNumberOfCopiesIssued()-1");
		transaction.commit();
		session.close();
	}
   
   
	   public boolean deleteBook(int issueCode) {
		   if(SessionFactoryUtil.getFactory()!= null) {
		   session = SessionFactoryUtil.getFactory().openSession();
		   transaction = session.beginTransaction();
		   IssueDetails issueDetails = getBookById(issueCode);
	       session.delete(issueDetails);
	       transaction.commit();
			session.close();
			return true;
		}else {
			return false;
			}
		}
	   

	   
	   public IssueDetails getBookById(int issueCode) {
			System.out.println("In BookIssueMasterDAO getBookById()");
	        if(SessionFactoryUtil.getFactory()!= null) {  
			session = SessionFactoryUtil.getFactory().openSession();
				IssueDetails issueDetails = session.get(IssueDetails.class, issueCode);
				if(issueDetails != null) {
					session.close();
					return issueDetails;
				}
				session.close();
				return null;
			}else {
				return null;
		}
}
		
  }

