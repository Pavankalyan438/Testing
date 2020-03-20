package com.capgemini.service;

import java.util.ArrayList;
import java.util.Set;

import com.capgemini.dao.LoanRequestDao;
import com.capgemini.dao.NoAcceptedException;
import com.capgemini.dao.NoRejException;
import com.capgemini.entity.DetailsBean;

public class LoanRequestService {
	static LoanRequestDao dao=new LoanRequestDao();

	public String loanRequest(DetailsBean bean) {
		
		String s=dao.loanRequest(bean);
		return s;
	}
	public Set getAllRequests() {
		Set s=dao.getAllRequests();
		return s;
	}
	public ArrayList getAcceptedLoans() throws NoAcceptedException{
		ArrayList d=dao.getAcceptedLoans();
		return d;
		}
	public ArrayList getRejectedLoans() throws NoRejException {
		ArrayList d=dao.getRejectedLoans();
		return d;		
	}
	public double getEmi(String accountid) throws NoAcceptedException {
		return dao.getEmi(accountid);
	}

}
