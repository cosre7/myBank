package com.pyj.bankapp.service;

/*
 * 은행 계좌 명세서 가져오기, 은행 계좌 상세 정보 살펴보기, 연락처 갱신하기, 암호 변경하기, 고객 센터 연략하기
 * 등의 서비스를 가진다.
 * */
public class PersonalBankService {
	private JmsMessageSender jmsMessageSender; // JMS 메시지 전송
	private EmailMessageSender emailMessageSender; // 전자우편 전송
	private WebServiceInvoker webServiceInvoker; // 외부 웹 서비스 호출
	
	// 의존 관계를 생성자 인수와 세터 메서드 인수로 주입한다.
	// 1. 생성자 인수로 주입
	public PersonalBankSercie(JmsMessageSender jmsMessageSender,
							  EmailMessageSender emailMessageSender) {
		
		this.jmsMessageSender = jmsMessageSender;
		this.emailMessageSender = emailMessageSender;
	}

	// 2. 세터 메서드 인수로 주입
	public void setWebServiceInvoker(WebServiceInvoker webServiceInvoker) {
		this.webServiceInvoker = webServiceInvoker;
		
	}
}
