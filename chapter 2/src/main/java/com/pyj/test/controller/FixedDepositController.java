package com.pyj.bankapp.controller;

import com.pyj.bankapp.domain.FixedDepositDetails;
import com.pyj.bankapp.service.FixedDepositService;

public interface FixedDepositController {
	FixedDepositService getFixedDepositService();

	boolean submit();

	FixedDepositDetails get();
}
