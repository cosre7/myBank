package com.pyj.bankapp;

/*
 * ������ ���� ���޹޴� �� ��Ʈ�ѷ�
 * - FixedDepositService�� createFixedDeposit �޼��� ȣ��
 * */
public class FixedDepositController00 {

	// FixedDepositController�� FixedDepositService�� �����ϰ��ִ�.
	private FixedDepositService00 fixedDepositService;
	
	
//	���� 1-1
//	/* 
//	 * FixedDepositController�� �����ڴ� ���߿� �ڽ��� submit �޼��忡�� ����� 
//	 * FixedDepositService�� �ν��Ͻ��� �����.
//	 */
//	public FixedDepositController() { 
//		fixedDepositService = new FixedDepositService();
//	}
	
	// ���� 1-2
	public FixedDepositController00(FixedDepositService00 fixedDepositService) {
		// FixedDepositService �ν��Ͻ��� FixedDepositController �ν��Ͻ��� ������ �μ��� ���� 
		// -> FixedDepositController Ŭ������ ������ ������ ������ �� �ִ�.
		// -> FixedDepositController�� �������� � �������̽��� Ŭ������ �����ϰų� Ȯ������ �ʴ´�.
		/*
		 * FixedDepositController�� ������ ������ �����Ϸ��� FixedDepositController Ŭ������
		 * FixedDepositService�� ���� �������踦 ������ �μ��� �ްų� ���� �޼��� �μ��� �޾ƾ� �Ѵ�. 
		 */
		this.fixedDepositService = fixedDepositService;
	}
	
//	public boolean submit() {
//		//-- ���� ������ �� ���� ����
////		fixedDepositService.save();
//	}
}
