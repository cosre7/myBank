package com.pyj.test.service;

import com.pyj.test.dao.FixedDepositDao;
import com.pyj.test.domain.FixedDepositDetails;

public class FixedDepositServiceImpl {
	// FixedDepositDao �������̽��� ������ ����ִ�.
	// -> FixedDepositIbatisDao, FixedDepositJdbcDao, FixedDepositHibernateDao ����
	//    FixedDepositDao �������̽� ���� �� � ���̵� ���� �����ϴ�.
	private FixedDepositDao fixedDepositDao;
	
	public void setFixedDepositDao(FixedDepositDao fixedDepositDao) {
		this.fixedDepositDao = fixedDepositDao;
	}
	
	public FixedDepositDetails getFixedDepositDetails(long id) {
		return fixedDepositDao.getFixedDepositDetails(id);
	}
	
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		return fixedDepositDao.createFixedDeposit(fdd);
	}
}
