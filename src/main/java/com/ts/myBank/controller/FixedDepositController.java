package com.ts.myBank.controller;

public class FixedDepositController {

	// FixedDepositController�� FixedDepositService�� �����ϰ��ִ�.
	private FixedDepositService fixedDepositService;
	
	
//	���� 1-1
//	/* 
//	 * FixedDepositController�� �����ڴ� ���߿� �ڽ��� submit �޼��忡�� ����� 
//	 * FixedDepositService�� �ν��Ͻ��� �����.
//	 */
//	public FixedDepositController() { 
//		fixedDepositService = new FixedDepositService();
//	}
	
	// ���� 1-2
	public FixedDepositController(FixedDepositService fixedDepositService) {
		// FixedDepositService �ν��Ͻ��� FixedDepositController �ν��Ͻ��� ������ �μ��� ���� 
		// -> FixedDepositController Ŭ������ ������ ������ ������ �� �ִ�.
		// -> FixedDepositController�� �������� � �������̽��� Ŭ������ �����ϰų� Ȯ������ �ʴ´�.
		/*
		 * FixedDepositController�� ������ ������ �����Ϸ��� FixedDepositController Ŭ������
		 * FixedDepositService�� ���� �������踦 ������ �μ��� �ްų� ���� �޼��� �μ��� �޾ƾ� �Ѵ�. 
		 */
		this.fixedDepositService = fixedDepositService;
	}
	
	public boolean submit() {
		//-- ���� ������ �� ���� ����
		fixedDepositService.save();
	}
}
