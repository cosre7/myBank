import java.util.logging.Logger;

/*
 * 예제 1-16
 * */
public class BankApp {

	private static Logger logger = LogManager.getLogger(BankApp.class);
	
	public static void main(String args[]) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");
		
		/* 
		 * 1. ApplicationContext의 getBean 메서드를 호출해 스프링 컨테이너에서 
		 * FixedDepositController 빈의 인스턴스를 가져온다.
		 * - getBean에 넘기는 인수는 스프링 컨테이너에서 가져오려는 빈의 이름
		 * 		-> 반드시 가져오려는 빈의 id나 name 속성과 같아야 한다. 
		 * 		-> 일치하는 빈을 찾을 수 없으면 getBean 메서드가 예외를 발생시킨다.*/
		FixedDepositController fixedDepositController = 
				(fixedDepositController) context.getBean("controller");
		
		/*
		 * 2. FixedDepositController 빈의 submit과 get 메서드를 호츨한다.
		 * */
		logger.info("Submission status of fixed deposit : " 
				+ fixedDepositController.submit());
		logger.info("Returned fixed deposit info : " + fixedDepositController.get());
		
	}
}
