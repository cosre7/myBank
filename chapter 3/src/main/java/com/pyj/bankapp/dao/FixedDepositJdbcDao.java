package com.pyj.bankapp.dao;

/*
 * databaseInfo �Ӽ��� FixedDepositJdbcDao Ŭ������ ���� ���踦 ǥ���ϸ�, �� ���� ����� setDatabaseInfo
 * �޼��忡 ���� �����ȴ�.
 * */
public class FixedDepositJdbcDao {

	private DatabaseInfo databaseInfo;
	
	public FixedDepositJdbcDao() {}
	
	public void setDatabaseInfo(DatabaseInfo databaseInfo) {
		this.databaseInfo = databaseInfo;
	}
}
