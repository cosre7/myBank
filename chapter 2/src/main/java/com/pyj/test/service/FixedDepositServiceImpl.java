package com.pyj.test.service;

import com.pyj.test.dao.FixedDepositDao;
import com.pyj.test.domain.FixedDepositDetails;

public class FixedDepositServiceImpl {
	// FixedDepositDao 인터페이스의 참조가 들어있다.
	// -> FixedDepositIbatisDao, FixedDepositJdbcDao, FixedDepositHibernateDao 등의
	//    FixedDepositDao 인터페이스 구현 중 어떤 것이든 주입 가능하다.
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
