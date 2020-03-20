package com.capgemini.entity;

public class DetailsBean {
	private String accountid;
	double loanAmount;
	private String loanType;
	private int loanTenure;
	private double loanRoi;
	private String loanStatus;
	private int creditScore;
	
	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public double getLoanRoi() {
		return loanRoi;
	}

	public void setLoanRoi(double loanRoi) {
		this.loanRoi = loanRoi;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public DetailsBean(String accountid, double loanAmount, String loanType, int loanTenure, double loanRoi,
			String loanStatus, int creditScore) {
		super();
		this.accountid = accountid;
		this.loanAmount = loanAmount;
		this.loanType = loanType;
		this.loanTenure = loanTenure;
		this.loanRoi = loanRoi;
		this.loanStatus = loanStatus;
		this.creditScore = creditScore;
	}

	@Override
	public String toString() {
		return "accountid=" + accountid +"\nloanAmount=" + loanAmount + "\nloanType=" + loanType
				+ "\nloanTenure=" + loanTenure + "\nloanRoi=" + loanRoi + "\nloanStatus=" + loanStatus
				+ "\ncreditScore=" + creditScore +"\n";
	}
	

}
