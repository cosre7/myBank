package com.ts.myBank.controller;

public class FixedDepositController {

	// FixedDepositController�� FixedDepositService�� �����ϰ��ִ�.
	private FixedDepositService fixedDepositService;
	
	
//	1�ܰ�
//	/* 
//	 * FixedDepositController�� �����ڴ� ���߿� �ڽ��� submit �޼��忡�� ����� 
//	 * FixedDepositService�� �ν��Ͻ��� �����.
//	 */
//	public FixedDepositController() { 
//		fixedDepositService = new FixedDepositService();
//	}
	
	public FixedDepositController(FixedDepositService fixedDepositService) {
		// FixedDepositService �ν��Ͻ��� FixedDepositController �ν��Ͻ��� ������ �μ��� ���� 
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
