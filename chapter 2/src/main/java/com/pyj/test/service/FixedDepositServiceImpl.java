package com.pyj.bankapp.service;

import com.pyj.bankapp.dao.FixedDepositDao;
import com.pyj.bankapp.domain.FixedDepositDetails;

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
