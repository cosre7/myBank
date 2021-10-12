package com.pyj.bankapp;

import com.pyj.bankapp.dao.FixedDepositDao;
import com.pyj.bankapp.dao.FixedDepositHibernateDao;
import com.pyj.bankapp.dao.FixedDepositJdbcDao;

/*
 * �ν��Ͻ� ���丮 �޼��带 ȣ���� �� �ʱ�ȭ
 * - Ŭ������ �ν��Ͻ� ���丮 �޼��带 �����Ѵٸ�, Ŭ�������� public �����ڰ� ���ǵž� �Ѵ�.
 *   -> �׷��߸� ������ �����̳ʰ� �ش� Ŭ������ �ν��Ͻ��� ������ �� �ִ�.
 * */
public class FixedDepositDaoFactory {
	public FixedDepositDaoFactory() {}
	
	/*
	 * FixedDepositDao �ν��Ͻ��� ���� ��ȯ�ϴ� �ν��Ͻ� ���丮 �޼���
	 * */
	public FixedDepositDao getFixedDepositDao(String daoType) {
		FixedDepositDao fixedDepositDao = null;
		
		// applicationContext.xml�� ���� �� ���Ǵ� FixedDepositDaoFactory�� getFixedDepositDao �޼��带 ȣ��
		// -> �� ȣ��� FixedDepositJdbcDao �ν��Ͻ��� ����� ��ȯ
		if ("jdbc".equalsIgnoreCase(daoType)) {
			fixedDepositDao = new FixedDepositJdbcDao();
		}
		if ("hibernate".equalsIgnoreCase(daoType)) {
			fixedDepositDao = new FixedDepositHibernateDao();
		}
		
		return fixedDepositDao;
	}
}
