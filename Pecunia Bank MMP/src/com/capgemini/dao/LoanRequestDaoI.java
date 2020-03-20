package com.capgemini.dao;

import java.util.ArrayList;
import java.util.Set;

import com.capgemini.entity.DetailsBean;

public interface LoanRequestDaoI {
	public String loanRequest(DetailsBean bean) ;
	public Set getAllRequests();
	public ArrayList getAcceptedLoans() throws NoAcceptedException;
	public ArrayList getRejectedLoans() throws NoRejException;
	public double getEmi(String accountid) throws NoAcceptedException;
	
}
