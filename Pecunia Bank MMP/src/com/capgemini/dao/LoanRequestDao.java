package com.capgemini.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.capgemini.entity.DetailsBean;

public class LoanRequestDao {
	Set BankDetails=new HashSet(); 
	 DetailsBean db;
	 double emi;
	HashMap<String, DetailsBean> request=new HashMap<>();
	public LoanRequestDao(){
		BankDetails.add("12341234");
		BankDetails.add("1231232");	
	}

	public String loanRequest(DetailsBean bean) {
		String b=bean.getAccountid();
		int a=0;
		Iterator i=BankDetails.iterator();
		while(i.hasNext()){
			if(i.next().equals(b)){
				//System.out.println("entered");
				a=3;
			}
		}
		if(a>1){
			request.put(b, bean);
			return "Loan requested successfully";
		}
		else {
			return "you dont have any account";
		}
		
	}

	public Set getAllRequests() {
		Set s=request.entrySet();
		return s;
	}

	public ArrayList getAcceptedLoans() throws NoAcceptedException {
		//DetailsBean db;
		ArrayList l=new ArrayList<>();
		Iterator i4=BankDetails.iterator();
		while(i4.hasNext()){
		String s=(String) i4.next();
		 db=request.get(s);
		 if(db==null){
			continue;
		 }else{
		if(db.getCreditScore()>500){
			db.setLoanStatus("accepted");
			l.add(db);	
		}
		}}if(!(l.size()>0)){
			throw new NoAcceptedException("No rejections");
		}else{
			return l;
		
		}
	}
	public ArrayList getRejectedLoans() throws NoRejException{
		
		ArrayList l=new ArrayList<>();
		Iterator i4=BankDetails.iterator();
		while(i4.hasNext()){
		String s=(String) i4.next();
		 db=request.get(s);
		 if(db==null){
			 continue;
		 }
		 else{
		 if(db.getCreditScore()<500){
			db.setLoanStatus("rejected");
			l.add(db);	
		 }
		}}
		if(!(l.size()>0)){
			throw new NoRejException("No rejections");
		}else{
			return l;
		
		}
		
	}

	public double getEmi(String accountid) throws NoAcceptedException {
		 db= request.get(accountid);
		 if(db==null){
			 
			 throw new NoAcceptedException("No Emi");
		 }
		 else{
		 if(db.getLoanStatus().equals("accepted")){
		  emi=(db.getLoanAmount()*db.getLoanRoi()*db.getLoanTenure())/100;
		 }
		 return emi;
		
	}}}

	

