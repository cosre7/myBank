package com.pyj.bankapp.service;

/*
 * 은행 계좌 명세서 가져오기, 은행 계좌 상세 정보 살펴보기, 연락처 갱신하기, 암호 변경하기, 고객 센터 연략하기
 * 등의 서비스를 가진다.
 * */
public class PersonalBankService {
	private JmsMessageSender jmsMessageSender; // JMS 메시지 전송
	private EmailMessageSender emailMessageSender; // 전자우편 전송
	private WebServiceInvoker webServiceInvoker; // 외부 웹 서비스 호출
	
	// 각 의존관계마다 세터 메서드를 정의
	public void setJmsMessageSender(JmsMessageSender jmsMessageSender) {
		this.jmsMessageSender = jmsMessageSender;
	}
	
	public void setEmailMessageSender(EmailMessageSender emailMessageSender) {
		this.emailMessageSender = emailMessageSender;
	}
	
	public void setWebServiceInvoker(WebServiceInvoker webServiceInvoker) {
		this.webServiceInvoker = webServiceInvoker;
	}
	
}
