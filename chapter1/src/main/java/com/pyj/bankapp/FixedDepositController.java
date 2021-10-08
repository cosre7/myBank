import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FixedDepositController {
	// 예제 1-12
	// FixedDepositService의 의존관계는 setFixedDepositService 메서드를 통해 FixedDepositController에 전달
//	public void setFixedDepositService(FixedDepositService fixedDepositService) {
//		logger.info("setting fixedDepositService property");
//		this.fixedDepositService = fixedDepositService;
//	}
//	
//	public void submit() {
//		fixedDepositService.createFixedDeposit(new FixedDepositDetails
//				( 1, 10000, 365, "someemail@something.com"));
//	}
	
	// 예제 1-13
	// 빈 클래스의 세터 메서드를 이용해 의존 관계가 주입되는 과정
	private static Logger logger = LogManager.getLogManager(FixedDepositController.class);
	
	// FixedDepositService 타입의 fixedDepositService 인스턴스 변수 정의
	private FixedDepositService fixedDepositService;
	public FixedDepositController() {
		logger.info("initializing");
	}
	
	// fixedDepositService 변수는 setFixedDepositService 메서드로 설정
	public void setFixedDepositService(FixedDepositService fixedDepositService) {
		logger.info("Setting fixedDepositService property");
		this.fixedDepositService = fixedDepositService;
	}
}
