package com.pyj.bankapp.dao;

/*
 * databaseInfo 속성은 FixedDepositJdbcDao 클래스의 의존 관계를 표현하며, 이 의존 관계는 setDatabaseInfo
 * 메서드에 의해 충족된다.
 * */
public class FixedDepositJdbcDao {

	private DatabaseInfo databaseInfo;
	
	public FixedDepositJdbcDao() {}
	
	public void setDatabaseInfo(DatabaseInfo databaseInfo) {
		this.databaseInfo = databaseInfo;
	}
}
