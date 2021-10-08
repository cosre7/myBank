package com.pyj.test.controller;

import com.pyj.test.domain.FixedDepositDetails;
import com.pyj.test.service.FixedDepositService;

public interface FixedDepositController {
	FixedDepositService getFixedDepositService();

	boolean submit();

	FixedDepositDetails get();
}
