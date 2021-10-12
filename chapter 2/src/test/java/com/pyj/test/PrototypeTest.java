package com.pyj.test;

import static org.junit.Assert.assertNotSame;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.pyj.bankapp.domain.FixedDepositDetails;

public class PrototypeTest {
	private static ApplicationContext context;
	
	/*
	 * 스프링 컨테이너에서 얻은 두 가지 fixedDepositDetails 빈 인스턴스가 서로 다르다는 사실을 보여주는 메서드
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
