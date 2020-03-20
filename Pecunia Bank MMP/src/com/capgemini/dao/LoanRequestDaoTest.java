package com.capgemini.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Set;

import org.junit.Test;

import com.capgemini.entity.DetailsBean;

public class LoanRequestDaoTest {
	LoanRequestDao dao = new LoanRequestDao();
	DetailsBean bean = new DetailsBean("1231232", 12333, "dd", 33, 12, "pending", 599);

	@Test
	public void testLoanRequest() {
		String s = dao.loanRequest(bean);
		assertNotEquals(s, "Loan requested succesfully");
	}

	@Test
	public void testGetAllRequests() {
		Set d = null;
		Set s = dao.getAllRequests();
		assertNotEquals(s, d);

	}

	@Test
	public void testGetEmi() {
		double d = dao.getEmi("1231232");
		assertNotEquals(655.42, d);

	}

}
