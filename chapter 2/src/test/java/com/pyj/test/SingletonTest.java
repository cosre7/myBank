package com.pyj.test;

import static org.junit.Assert.assertSame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pyj.bankapp.controller.FixedDepositController;
import com.pyj.bankapp.dao.FixedDepositDao;

public class SingletonTest {

	private static ApplicationContext context;
	
	/*
	 * 해당 테스트 클래스의 모든 테스트 메서드보다 먼저 init 메서드를 실행하도록 지정
	 * - @BeforeClass 설정 메서드는 단 한 번 실행된 후 @Test 를 설정한 메서드가 실행
	 * */
	@BeforeClass
	public static void init() {
		/*
		 * init 메서드는 설정 메타데이터를 classPathXmlApplicationContext의 생성자에
		 * 전달해서 ApplicationContext 객체 인스턴스를 만든다.
		 * */
		context = new ClassPathXmlApplicationContext(
				"classpath:MEAT-INF/spring/applicationContext.xml");
	}
	
	/* ApplicationContext의 getBean 메서드를 여러 번 호출할 때 반환되는
		Controller 빈 인스턴스가 모두 다른지 같은지 검사하는 메서드
	*/
	@Test
	public void testInstances() {
		/*
		 * controller 빈의 인스턴스를 2개 얻은 후 assertSame 단언문을 활용해
		 * 두 인스턴스가 동일한지 검사
		 * - controller 빈이 싱글턴 스코프이기 때문에 controller1과 controller2의 
		 *   빈 인스턴스는 같다.
		 *   -> 스프링 컨테이너가 ApplicationContext의 getBean 메서드를 여러 번 
		 *   호출해도 똑같은 controller 빈을 반환한다.
		 * */
		FixedDepositController controller1 = 
				(FixedDepositController) context.getBean("controller");
		FixedDepositController controller2 = 
				(FixedDepositController) context.getBean("controller");
		assertSame("Different FixedDepositController instances", controller1, controller2);
	}
	
	/*
	 * FixedDepositController에 의해 참조되는 FixedDepositDao 인스턴스가 ApplicationContext의
	 * getBean 메서드를 호출해 직접 얻은 인스턴스와 같은지 검사
	 * */
	@Test
	public void testReference() {
		FixedDepositController controller = 
				(FixedDepositController) context.getBean("controller");
		
		// FixedDepositController 빈이 참조하는 FixedDepositDao 인스턴스를 읽는다.
		FixedDepositDao fixedDepositDao1 = 
				controller.getFixedDepositService().getFixedDepositDao();
		// ApplicationContext의 getBean 메서드를 사용해 FixedDepositDao 빈의 다른 인스턴스를 읽는다.
		FixedDepositDao fixedDepositDao2 = (FixedDepositDao) context.getBean("dao");
		assertSame("Different FixedDepositDao instances", fixedDepositDao1, fixedDepositDao2);
	}
}
