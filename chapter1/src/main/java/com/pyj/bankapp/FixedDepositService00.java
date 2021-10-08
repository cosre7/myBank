package src.main;

/*
 * FixedDepositDetails ��ü���� ���� ���� ������ ����ִ�. 
 * */
//@ManagedResource(objectName = "fixed_deposit_service:name=FixedDepositService") // ���� 1-9
public class FixedDepositService00 {

//	public FixedDepositDetails getFixedDepositDetails() {}
	
	// ���� 1-4 ���ο� ���⿹�ݰ� ������ ���⿹�� ������ �ݾ� �̵��� �� ���� �̷������ �ϴ� �� -> Ʈ����� �ȿ��� �ݵ�� ����
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {}
	
	// ���� 1-5 JDBC Connection ��ü�� ����� ���α׷����� �����ͺ��̽� Ʈ����� ���� ���� -> ���� Ʈ�����
	/*
	 * JDBC Connection ��ü ��� -> Ʈ����� �ڿ��� �ϳ��� ��� ��ȿ => ���� Ʈ�����
	 * JTA API(�ڹ� Ʈ����� API) -> Ʈ����� �ڿ��� �� �̻��� ��� ��ȿ => ���� Ʈ�����
	 * - ����Ʈ������� ���� Ʈ����� �ȿ��� ������ �� ����.
	 * */
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
//		
//		Connection con = ; 
//		try {
//			con.setAutoCommit(false);
//			//-- �����ͺ��̽� ���̺��� �����ϴ� SQL ���� ���� �����Ѵ�.
//			con.commit();
//		} catch(SQLException sqle) {
//			con.rollback();
//		}
//	}
	
	// ���� 1-6 @Transactional �ֳ����̼� ���
	/*
	 * �������� �˾Ƽ� Ʈ������� �����ϰ� �ȴ�. -> Ʈ����� ���� API�� ���� �ٷ� �ʿ䰡 ��������.
	 * */
//	@Transactional 
//	@Secured({ "SAVINGS_ACCOUNT_CUSTOMER", "APPLICATION_ADMIN" }) // ���� 1-7 ���� �߰�
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
//		
//	}
	
	// ���� 1-8 active �÷��� �߰�
	/*
	 * ������ �����ٷ� ���ø����̼��� ���� �� �����ٷ��� ���� 9�ÿ��� activeService ���� ���� 6�ÿ��� deactiveService ����
	 * - ���� �� �����ٷ� ���ø����̼��� JMX API�� ����� ���ݿ��� FixedDepositService �ν��Ͻ��� ��ȣ �ۿ�
	 * */
//	private boolean active;
//	
//	public FixedDepositDetails getFixedDepositDetails() {
//		if(active) {}
//	}
//	
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
//		if(active) {}
//	}
//	
//	public void activateService() {
//		active = true;
//	}
//	
//	public void deactivateService() {
//		active = false;
//	}
	
	// ���� 1-9. ������ JMX ���� ���
	/*
	 * @ManagedResource�� @ManagedOperation�� ����� FixedDepositService Ŭ������ �ν��Ͻ��� MBean
	 * ������ ����ϰ� ������ activateService�� deactivateService �޼��带 JMX �������� �����Ų��.
	 * - JMX API�� ���� ������� �ʰ� FixedDepositService�� �ڽ��� �޼��带 JMX �������� �����ų �� �ִ�.
	 * */
//	private boolean active;
//	
//	public FixedDepositDetails getFixedDepositDetails() {
//		if(active) {}
//	}
//	
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
//		if(active) {}
//	}
//	
//	@ManagedOperation
//	public void activateService() {
//		active = true;
//	}
//	
//	@ManagedOperation
//	public void deactivateService() {
//		active = false;
//	}
	
	// ���� 1-10. JMS �޽����� ������ FixedDepositService
	/*
	 * JMS(Java Message Service)�� ����ϸ� JMS �����ڿ��� �޽����� �ްų� ���� �� �ִ�.
	 * - ���� ������ ���ڿ������� �ް� �ʹٴ� ��û�� ������ FixedDepositService�� ��û�� �� ������
	 *   JMS �޽�¡ �̵��� ������ ���߿� �޽��� �����ʷ� ó���ȴ�.
	 * */
//	@Autowired
//	private transient JmsTemplate jmsTemplate;
//	
//		public boolean submitRequest(Request request) {
//			jmsTemplate.convertAndSend(request);
//		}
	
	// ���� 1-11. ���� ������ �� ������ ĳ���ϴ� FixedDepositService
	/*
	 * �������� ĳ�� �߻�ȭ�� ����ϸ� ���ø����̼ǿ��� �ϰ��� �ְ� ĳ�ø� ����� �� �ִ�.
	 * - MyBank ���ø����̼��� ��� ĳ�� �ַ���� ����� ���� ���� �� ������ ���� �б� ���� ������ ����Ų��.
	 * */
	
	// getFixedDepositDetails �޼��尡 �������� ĳ�� �߻�ȭ ����� ����� ���� ������ �� ������ ĳ��
//	@Cacheable("fixedDeposits") // getFixedDepositDetails �޼��尡 ��ȯ�ϴ� ���� ���� ������ ĳ�ÿ� ����
//	public FixedDepositDetails getFixedDepositDetails() {}
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {}
	
	
}
