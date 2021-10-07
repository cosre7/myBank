package com.ts.myBank.service;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "fixed_deposit_service:name=FixedDepositService") // ���� 1-9
public class FixedDepositService {

//	public FixedDepositDetails getFixedDepositDetails() {}
	
	// ���� 1-4 ���ο� ���⿹�ݰ� ������ ���⿹�� ������ �ݾ� �̵��� �� ���� �̷������ �ϴ� �� -> Ʈ����� �ȿ��� �ݵ�� ����
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {}
	
	// ���� 1-5 JDBC Connection ��ü�� ����� ���α׷����� �����ͺ��̽� Ʈ����� ���� ���� -> ���� Ʈ�����
	/*
	 * JDBC Connection ��ü ��� -> Ʈ����� �ڿ��� �ϳ��� ��� ��ȿ => ���� Ʈ�����
	 * JTA API(�ڹ� Ʈ����� API) -> Ʈ����� �ڿ��� �� �̻��� ��� ��ȿ => ���� Ʈ�����
	 * - ����Ʈ������� ���� Ʈ����� �ȿ��� ������ �� ����.
	 * */
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
//		
//		Connection con = ; 
//		try {
//			con.setAutoCommit(false);
//			//-- �����ͺ��̽� ���̺��� �����ϴ� SQL ���� ���� �����Ѵ�.
//			con.commit();
//		} catch(SQLException sqle) {
//			con.rollback();
//		}
//	}
	
	// ���� 1-6 @Transactional �ֳ����̼� ���
	/*
	 * �������� �˾Ƽ� Ʈ������� �����ϰ� �ȴ�. -> Ʈ����� ���� API�� ���� �ٷ� �ʿ䰡 ��������.
	 * */
//	@Transactional 
//	@Secured({ "SAVINGS_ACCOUNT_CUSTOMER", "APPLICATION_ADMIN" }) // ���� 1-7 ���� �߰�
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
//		
//	}
	
	// ���� 1-8 active �÷��� �߰�
	/*
	 * ������ �����ٷ� ���ø����̼��� ���� �� �����ٷ��� ���� 9�ÿ��� activeService ���� ���� 6�ÿ��� deactiveService ����
	 * - ���� �� �����ٷ� ���ø����̼��� JMX API�� ����� ���ݿ��� FixedDepositService �ν��Ͻ��� ��ȣ �ۿ�
	 * */
//	private boolean active;
//	
//	public FixedDepositDetails getFixedDepositDetails() {
//		if(active) {}
//	}
//	
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
//		if(active) {}
//	}
//	
//	public void activateService() {
//		active = true;
//	}
//	
//	public void deactivateService() {
//		active = false;
//	}
	
	// ���� 1-9. ������ JMX ���� ���
	/*
	 * @ManagedResource�� @ManagedOperation�� ����� FixedDepositService Ŭ������ �ν��Ͻ��� MBean
	 * ������ ����ϰ� ������ activateService�� deactivateService �޼��带 JMX �������� �����Ų��.
	 * - JMX API�� ���� ������� �ʰ� FixedDepositService�� �ڽ��� �޼��带 JMX �������� �����ų �� �ִ�.
	 * */
	private boolean active;
	
	public FixedDepositDetails getFixedDepositDetails() {
		if(active) {}
	}
	
	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
		if(active) {}
	}
	
	@ManagedOperation
	public void activateService() {
		active = true;
	}
	
	@ManagedOperation
	public void deactivateService() {
		active = false;
	}
	
	
}
