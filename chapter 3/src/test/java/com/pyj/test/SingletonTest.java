package com.pyj.test;

import static org.junit.Assert.assertNotSame;
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
	 * �ش� �׽�Ʈ Ŭ������ ��� �׽�Ʈ �޼��庸�� ���� init �޼��带 �����ϵ��� ����
	 * - @BeforeClass ���� �޼���� �� �� �� ����� �� @Test �� ������ �޼��尡 ����
	 * */
	@BeforeClass
	public static void init() {
		/*
		 * init �޼���� ���� ��Ÿ�����͸� classPathXmlApplicationContext�� �����ڿ�
		 * �����ؼ� ApplicationContext ��ü �ν��Ͻ��� �����.
		 * */
		context = new ClassPathXmlApplicationContext(
				"classpath:MEAT-INF/spring/applicationContext.xml");
	}
	
	/* ApplicationContext�� getBean �޼��带 ���� �� ȣ���� �� ��ȯ�Ǵ�
		Controller �� �ν��Ͻ��� ��� �ٸ��� ������ �˻��ϴ� �޼���
	*/
	@Test
	public void testInstances() {
		/*
		 * controller ���� �ν��Ͻ��� 2�� ���� �� assertSame �ܾ��� Ȱ����
		 * �� �ν��Ͻ��� �������� �˻�
		 * - controller ���� �̱��� �������̱� ������ controller1�� controller2�� 
		 *   �� �ν��Ͻ��� ����.
		 *   -> ������ �����̳ʰ� ApplicationContext�� getBean �޼��带 ���� �� 
		 *   ȣ���ص� �Ȱ��� controller ���� ��ȯ�Ѵ�.
		 * */
		FixedDepositController controller1 = 
				(FixedDepositController) context.getBean("controller");
		FixedDepositController controller2 = 
				(FixedDepositController) context.getBean("controller");
		assertSame("Different FixedDepositController instances", controller1, controller2);
	}
	
	/*
	 * FixedDepositController�� ���� �����Ǵ� FixedDepositDao �ν��Ͻ��� ApplicationContext��
	 * getBean �޼��带 ȣ���� ���� ���� �ν��Ͻ��� ������ �˻�
	 * */
	@Test
	public void testReference() {
		FixedDepositController controller = 
				(FixedDepositController) context.getBean("controller");
		
		// FixedDepositController ���� �����ϴ� FixedDepositDao �ν��Ͻ��� �д´�.
		FixedDepositDao fixedDepositDao1 = 
				controller.getFixedDepositService().getFixedDepositDao();
		// ApplicationContext�� getBean �޼��带 ����� FixedDepositDao ���� �ٸ� �ν��Ͻ��� �д´�.
		FixedDepositDao fixedDepositDao2 = (FixedDepositDao) context.getBean("dao");
		assertSame("Different FixedDepositDao instances", fixedDepositDao1, fixedDepositDao2);
	}
	
	/*
	 * ���� �ٸ� ������ �����̳� �ν��Ͻ��κ��� FixedDepositController �� �ν��Ͻ��� �� �� ���� ������ ��
	 * */
	@Test
	public void testSingletonScope() {
		// ���ο� �����̳ʸ� �����.
		ApplicationContext anotherContext = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");
		
		FixedDepositController fixedDepositController1 =
				(FixedDepositController) anotherContext.getBean("controller");
		
		FixedDepositController fixedDepositController2 = 
				(FixedDepositController) context.getBean("controller");
		
		assertNotSame("Same FixedDepositController instances",
				fixedDepositController1, fixedDepositController2);
		// �� ������ �����̳ʴ� �ڽŸ��� controller �� �ν��Ͻ��� ������.
	}
	
	/*
	 * dao�� anotherDao �� ���ǿ� �����ϴ� FixedDepositDaoImpl �ν��Ͻ��� ������ �˻�
	 * */
	@Test
	public void testSingletonScopePerBeanDef() {
		// ������ �����̳ʰ� dao�� anotherDao �� ���Ƿ� ������ �ν��Ͻ�
		FixedDepositDao fixedDepositDao1 = (FixedDepositDao) context.getBean("dao");
		FixedDepositDao fixedDepositDao2 = (FixedDepositDao) context.getBean("anotherDao");
		assertNotSame("Same FixedDepositDao instances", fixedDepositDao1, fixedDepositDao2);
	}
}
