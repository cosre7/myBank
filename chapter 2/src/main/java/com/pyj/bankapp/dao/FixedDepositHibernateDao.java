package com.pyj.bankapp.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;

import com.pyj.bankapp.domain.FixedDepositDetails;

public class FixedDepositHibernateDao implements FixedDepositDao {
	private static Logger logger = LogManager.getLogger(FixedDepositHibernateDao.class);

	private Map<Long, FixedDepositDetails> fixedDeposits = new HashMap<Long, FixedDepositDetails>();

	public FixedDepositHibernateDao() {
		logger.info("initializing");
	}

	public FixedDepositDetails getFixedDepositDetails(long id) {
		return fixedDeposits.get(id);
	}

	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		fixedDeposits.put(fdd.getId(), fdd);
		return true;
	}
}
