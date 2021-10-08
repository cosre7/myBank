package com.pyj.test.service;

import com.pyj.test.dao.FixedDepositDao;
import com.pyj.test.domain.FixedDepositDetails;

public interface FixedDepositService {
	FixedDepositDao getFixedDepositDao();

	FixedDepositDetails getFixedDepositDetails(long id);

	boolean createFixedDeposit(FixedDepositDetails fdd);

}
