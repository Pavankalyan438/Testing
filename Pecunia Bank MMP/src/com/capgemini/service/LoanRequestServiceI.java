package com.capgemini.service;

import java.util.ArrayList;
import java.util.Set;

import com.capgemini.dao.NoAcceptedException;
import com.capgemini.dao.NoRejException;
import com.capgemini.entity.DetailsBean;

public interface LoanRequestServiceI {
	public String loanRequest(DetailsBean bean);
	public Set getAllRequests();
	public ArrayList getAcceptedLoans() throws NoAcceptedException;
	public ArrayList getRejectedLoans() throws NoRejException;
	public double getEmi(String accountid) throws NoAcceptedException;
}
