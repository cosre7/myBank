package com.pyj.test;

import static org.junit.Assert.assertNotSame;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.pyj.bankapp.domain.FixedDepositDetails;

public class PrototypeTest {
	private static ApplicationContext context;
	
	/*
	 * ������ �����̳ʿ��� ���� �� ���� fixedDepositDetails �� �ν��Ͻ��� ���� �ٸ��ٴ� ����� �����ִ� �޼���
	 * */
	@Test
	public void testInstances() {
		FixedDepositDetails fixedDepositDetails1 = 
				(FixedDepositDetails)context.getBean("fixedDepositDetails");
		FixedDepositDetails fixedDepositDetails2 = 
				(FixedDepositDetails)context.getBean("fixedDepositDetails");
		
		assertNotSame("Same FixedDepositDetails instances", fixedDepositDetails1, fixedDepositDetails2);
	}
}
