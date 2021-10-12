package com.pyj.bankapp;

import com.pyj.bankapp.dao.FixedDepositDao;
import com.pyj.bankapp.dao.FixedDepositHibernateDao;
import com.pyj.bankapp.dao.FixedDepositJdbcDao;

/*
 * 인스턴스 팩토리 메서드를 호출해 빈 초기화
 * - 클래스가 인스턴스 팩토리 메서드를 정의한다면, 클래스에는 public 생성자가 정의돼야 한다.
 *   -> 그래야만 스프링 컨테이너가 해당 클래스의 인스턴스를 생성할 수 있다.
 * */
public class FixedDepositDaoFactory {
	public FixedDepositDaoFactory() {}
	
	/*
	 * FixedDepositDao 인스턴스를 만들어서 반환하는 인스턴스 팩토리 메서드
	 * */
	public FixedDepositDao getFixedDepositDao(String daoType) {
		FixedDepositDao fixedDepositDao = null;
		
		// applicationContext.xml에 따라 빈 정의는 FixedDepositDaoFactory의 getFixedDepositDao 메서드를 호출
		// -> 이 호출로 FixedDepositJdbcDao 인스턴스를 만들어 반환
		if ("jdbc".equalsIgnoreCase(daoType)) {
			fixedDepositDao = new FixedDepositJdbcDao();
		}
		if ("hibernate".equalsIgnoreCase(daoType)) {
			fixedDepositDao = new FixedDepositHibernateDao();
		}
		
		return fixedDepositDao;
	}
}
