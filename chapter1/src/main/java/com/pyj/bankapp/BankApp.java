import java.util.logging.Logger;

/*
 * ���� 1-16
 * */
public class BankApp {

	private static Logger logger = LogManager.getLogger(BankApp.class);
	
	public static void main(String args[]) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");
		
		/* 
		 * 1. ApplicationContext�� getBean �޼��带 ȣ���� ������ �����̳ʿ��� 
		 * FixedDepositController ���� �ν��Ͻ��� �����´�.
		 * - getBean�� �ѱ�� �μ��� ������ �����̳ʿ��� ���������� ���� �̸�
		 * 		-> �ݵ�� ���������� ���� id�� name �Ӽ��� ���ƾ� �Ѵ�. 
		 * 		-> ��ġ�ϴ� ���� ã�� �� ������ getBean �޼��尡 ���ܸ� �߻���Ų��.*/
		FixedDepositController fixedDepositController = 
				(fixedDepositController) context.getBean("controller");
		
		/*
		 * 2. FixedDepositController ���� submit�� get �޼��带 ȣ���Ѵ�.
		 * */
		logger.info("Submission status of fixed deposit : " 
				+ fixedDepositController.submit());
		logger.info("Returned fixed deposit info : " + fixedDepositController.get());
		
	}
}
