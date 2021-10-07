package com.ts.myBank.controller;

public class FixedDepositController {

	// FixedDepositController가 FixedDepositService에 의존하고있다.
	private FixedDepositService fixedDepositService;
	
	
//	예제 1-1
//	/* 
//	 * FixedDepositController의 생성자는 나중에 자신의 submit 메서드에서 사용할 
//	 * FixedDepositService의 인스턴스를 만든다.
//	 */
//	public FixedDepositController() { 
//		fixedDepositService = new FixedDepositService();
//	}
	
	// 예제 1-2
	public FixedDepositController(FixedDepositService fixedDepositService) {
		// FixedDepositService 인스턴스가 FixedDepositController 인스턴스의 생성자 인수로 전달 
		// -> FixedDepositController 클래스를 스프링 빈으로 설정할 수 있다.
		// -> FixedDepositController가 스프링의 어떤 인터페이스나 클래스를 구현하거나 확장하지 않는다.
		/*
		 * FixedDepositController를 스프링 빈으로 설정하려면 FixedDepositController 클래스가
		 * FixedDepositService에 대한 의존관계를 생성자 인수로 받거나 세터 메서드 인수로 받아야 한다. 
		 */
		this.fixedDepositService = fixedDepositService;
	}
	
	public boolean submit() {
		//-- 정기 예금의 상세 정보 저장
		fixedDepositService.save();
	}
}
