
/*
 * ClassPathXmlApplicationContext Ŭ������ ����� ������ ������ �����̳� �ν��Ͻ��� �����ش�.
 * */
public class BankApp {

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");
	}
}
