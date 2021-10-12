package com.pyj.bankapp.service;

/*
 * ���� ���� ���� ��������, ���� ���� �� ���� ���캸��, ����ó �����ϱ�, ��ȣ �����ϱ�, �� ���� �����ϱ�
 * ���� ���񽺸� ������.
 * */
public class PersonalBankService {
	private JmsMessageSender jmsMessageSender; // JMS �޽��� ����
	private EmailMessageSender emailMessageSender; // ���ڿ��� ����
	private WebServiceInvoker webServiceInvoker; // �ܺ� �� ���� ȣ��
	
	// �� �������踶�� ���� �޼��带 ����
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
