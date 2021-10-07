package com.ts.myBank.service;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "fixed_deposit_service:name=FixedDepositService") // 예제 1-9
public class FixedDepositService {

//	public FixedDepositDetails getFixedDepositDetails() {}
	
	// 예제 1-4 새로운 정기예금과 기존의 정기예금 사이의 금액 이동은 한 번에 이루어져야 하는 일 -> 트랜잭션 안에서 반드시 실행
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {}
	
	// 예제 1-5 JDBC Connection 객체를 사용해 프로그램에서 데이터베이스 트랜잭션 직접 관리 -> 지역 트랜잭션
	/*
	 * JDBC Connection 객체 사용 -> 트랜잭션 자원이 하나인 경우 유효 => 지역 트랜잭션
	 * JTA API(자바 트랜잭션 API) -> 트랜잭션 자원이 둘 이상인 경우 유효 => 전역 트랜잭션
	 * - 지역트랜잭션은 전역 트랜잭션 안에서 실행할 수 없다.
	 * */
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
//		
//		Connection con = ; 
//		try {
//			con.setAutoCommit(false);
//			//-- 데이터베이스 테이블을 변경하는 SQL 문을 여럿 실행한다.
//			con.commit();
//		} catch(SQLException sqle) {
//			con.rollback();
//		}
//	}
	
	// 예제 1-6 @Transactional 애너테이션 사용
	/*
	 * 스프링이 알아서 트랜잭션을 관리하게 된다. -> 트랜잭션 관리 API를 직접 다룰 필요가 없어진다.
	 * */
//	@Transactional 
//	@Secured({ "SAVINGS_ACCOUNT_CUSTOMER", "APPLICATION_ADMIN" }) // 예제 1-7 보안 추가
//	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
//		
//	}
	
	// 예제 1-8 active 플래그 추가
	/*
	 * 별도의 스케줄러 애플리케이션인 은행 앱 스케줄러가 오전 9시에는 activeService 실행 오후 6시에는 deactiveService 실행
	 * - 은행 앱 스케줄러 애플리케이션은 JMX API를 사용해 원격에서 FixedDepositService 인스턴스와 상호 작용
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
	
	// 예제 1-9. 스프링 JMX 지원 사용
	/*
	 * @ManagedResource와 @ManagedOperation을 사용해 FixedDepositService 클래스의 인스턴스를 MBean
	 * 서버에 등록하고 내부의 activateService와 deactivateService 메서드를 JMX 연산으로 노출시킨다.
	 * - JMX API를 직접 사용하지 않고도 FixedDepositService가 자신의 메서드를 JMX 연산으로 노출시킬 수 있다.
	 * */
	private boolean active;
	
	public FixedDepositDetails getFixedDepositDetails() {
		if(active) {}
	}
	
	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
		if(active) {}
	}
	
	@ManagedOperation
	public void activateService() {
		active = true;
	}
	
	@ManagedOperation
	public void deactivateService() {
		active = false;
	}
	
	
}
