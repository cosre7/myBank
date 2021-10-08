
/*
 * ClassPathXmlApplicationContext 클래스를 사용해 정의한 스프링 컨테이너 인스턴스를 보여준다.
 * */
public class BankApp {

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");
	}
}
