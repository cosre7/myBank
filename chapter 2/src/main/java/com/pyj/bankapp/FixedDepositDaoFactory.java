package com.pyj.bankapp;

import com.pyj.bankapp.dao.FixedDepositDao;
import com.pyj.bankapp.dao.FixedDepositHibernateDao;

/*
 * ���� �޼��忡 ���޵� �μ��� ������� FixedDepositDao �ν��Ͻ��� ����� ��ȯ�ϰ�,
 * ���� ���丮 �޼��带 �����ϴ� FixedDepositDaoFactory Ŭ����
 * */
public class FixedDepositDaoFactory {
	private FixedDepositDaoFactory() {}
	
	/*
	 * daoType�� �μ����� ���� FixedDepositHibernateDao, FixedDepositJdbcDao Ŭ������ �ν��Ͻ� ��
	 * �ϳ��� ������ getFixedDepositDao ���� �޼���
	 * */
	public static FixedDepositDao getFixedDepositDao(String daoType) {
		FixedDepositDao fixedDepositDao = null;
		
		if ("jdbc".equalsIgnoreCase(daoType)) {
			fixedDepositDao = new FixedDepositJdbcDao();
		}
		if ("hibernate".equalsIgnoreCase(daoType)) {
			fixedDepositDao = new FixedDepositHibernateDao();
		}
		
		return fixedDepositDao;
	}
}
