package com.capgemini.user;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.dao.NoAcceptedException;
import com.capgemini.dao.NoRejException;
import com.capgemini.entity.DetailsBean;
import com.capgemini.service.LoanRequestService;

public class LoanRequest {
	static LoanRequestService service = new LoanRequestService();

	public static void main(String[] args) {

		String accountid;
		String loanRequestId;
		double loanAmount;
		String loanType;
		int loanTenure;
		double loanRoi;
		String loanStatus;
		int creditScore;
		double loanEmi;
		System.out.println("Welcome to Pecunia Bank");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				System.out.println(
						"1:Loan request \n 2:To display all Request \n 3:Approved Loan \n 4:Rejected Loan \n 5:Loan Emi \n 6:Exit");
				int value = scanner.nextInt();
				switch (value) {

				case 1:
					System.out.println("Enter your Bank Account");
					accountid = scanner.next();
					System.out.println("enter the loan amount:");
					loanAmount = scanner.nextDouble();
					while (!(loanAmount > 1000 && loanAmount < 100000000)) {
						System.out.println("loan amount should be between 1000 and 100,00,000");
						loanAmount = scanner.nextDouble();
					}
					System.out.println("enter the loanType:");
					loanType = scanner.next();
					System.out.println("enter the tenure in months:");
					loanTenure = scanner.nextInt();
					while (!(loanTenure >= 12 && loanTenure <= 240)) {
						System.out.println("tenure should be between 12 to 240 months:");
						System.out.println("enter the tenure in months:");
						loanTenure = scanner.nextInt();
					}

					System.out.println("enter the creditScore:");
					creditScore = scanner.nextInt();
					while (!(creditScore >= 100 && creditScore <= 999)) {
						System.out.println("creditScore should be between 100 to 999:");
						System.out.println("enter the creditScore:");
						creditScore = scanner.nextInt();
					}
					loanStatus = "pending";
					if (creditScore >= 100 && creditScore <= 500)
						loanRoi = 14;
					else if (creditScore > 500 && creditScore <= 800)
						loanRoi = 8;
					else
						loanRoi = 4;
					DetailsBean bean = new DetailsBean(accountid, loanAmount, loanType, loanTenure, loanRoi, loanStatus,
							creditScore);
					String s = service.loanRequest(bean);
					System.out.println(s);
					break;
				case 2:
					Set s1 = service.getAllRequests();
					Iterator i1 = s1.iterator();
					while (i1.hasNext()) {
						Entry e = (Entry) i1.next();
						System.out.println(e.getKey());
						System.out.println(e.getValue());
					}
					break;
				case 3:
					try {
						ArrayList d = service.getAcceptedLoans();
						Iterator i = d.iterator();
						while (i.hasNext()) {
							System.out.println(i.next());
						}
					} catch (NoAcceptedException e) {
						System.out.println("Accepted Loans are not available");
					}
					break;

				case 4:
					try {
						ArrayList d1 = service.getRejectedLoans();
						Iterator i2 = d1.iterator();
						while (i2.hasNext()) {
							System.out.println(i2.next());
						}
					} catch (NoRejException e) {
						System.out.println("Rejected Loans are not avalilable");
					}
					break;
				case 5:
					System.out.println("Enter your accountno to calculate EMI");
					accountid = scanner.next();try{
					double emi = service.getEmi(accountid);
					System.out.println("Emi is " + emi + " for" + accountid);
					}catch (NoAcceptedException e) {
						System.out.println("No EMi's");
					}break;
				case 6:
					System.out.println("Thanks For Using Pecunia");
					System.exit(0);
				default:
					System.out.println("Choose the correct option");
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter only integer");
				break;
			}
		}
	}
}
