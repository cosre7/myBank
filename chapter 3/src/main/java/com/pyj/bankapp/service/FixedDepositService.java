package com.pyj.bankapp.service;

import com.pyj.bankapp.dao.FixedDepositDao;
import com.pyj.bankapp.domain.FixedDepositDetails;

public interface FixedDepositService {
	FixedDepositDao getFixedDepositDao();

	FixedDepositDetails getFixedDepositDetails(long id);

	boolean createFixedDeposit(FixedDepositDetails fdd);

}
