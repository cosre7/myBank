package com.pyj.bankapp;

import com.pyj.bankapp.dao.FixedDepositDao;
import com.pyj.bankapp.dao.FixedDepositHibernateDao;

/*
 * 정적 메서드에 전달된 인수를 기반으로 FixedDepositDao 인스턴스를 만들어 반환하고,
 * 정적 팩토리 메서드를 정의하는 FixedDepositDaoFactory 클래스
 * */
public class FixedDepositDaoFactory {
	private FixedDepositDaoFactory() {}
	
	/*
	 * daoType의 인수값에 따라 FixedDepositHibernateDao, FixedDepositJdbcDao 클래스의 인스턴스 중
	 * 하나를 만들어내는 getFixedDepositDao 정적 메서드
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
