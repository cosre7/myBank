import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FixedDepositController {
	// ���� 1-12
	// FixedDepositService�� ��������� setFixedDepositService �޼��带 ���� FixedDepositController�� ����
//	public void setFixedDepositService(FixedDepositService fixedDepositService) {
//		logger.info("setting fixedDepositService property");
//		this.fixedDepositService = fixedDepositService;
//	}
//	
//	public void submit() {
//		fixedDepositService.createFixedDeposit(new FixedDepositDetails
//				( 1, 10000, 365, "someemail@something.com"));
//	}
	
	// ���� 1-13
	// �� Ŭ������ ���� �޼��带 �̿��� ���� ���谡 ���ԵǴ� ����
	private static Logger logger = LogManager.getLogManager(FixedDepositController.class);
	
	// FixedDepositService Ÿ���� fixedDepositService �ν��Ͻ� ���� ����
	private FixedDepositService fixedDepositService;
	public FixedDepositController() {
		logger.info("initializing");
	}
	
	// fixedDepositService ������ setFixedDepositService �޼���� ����
	public void setFixedDepositService(FixedDepositService fixedDepositService) {
		logger.info("Setting fixedDepositService property");
		this.fixedDepositService = fixedDepositService;
	}
}
