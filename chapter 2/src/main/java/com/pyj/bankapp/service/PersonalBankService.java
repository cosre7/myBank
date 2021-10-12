package com.pyj.bankapp.service;

/*
 * ���� ���� ���� ��������, ���� ���� �� ���� ���캸��, ����ó �����ϱ�, ��ȣ �����ϱ�, �� ���� �����ϱ�
 * ���� ���񽺸� ������.
 * */
public class PersonalBankService {
	private JmsMessageSender jmsMessageSender; // JMS �޽��� ����
	private EmailMessageSender emailMessageSender; // ���ڿ��� ����
	private WebServiceInvoker webServiceInvoker; // �ܺ� �� ���� ȣ��
	
	// ���� ���踦 ������ �μ��� ���� �޼��� �μ��� �����Ѵ�.
	// 1. ������ �μ��� ����
	public PersonalBankSercie(JmsMessageSender jmsMessageSender,
							  EmailMessageSender emailMessageSender) {
		
		this.jmsMessageSender = jmsMessageSender;
		this.emailMessageSender = emailMessageSender;
	}

	// 2. ���� �޼��� �μ��� ����
	public void setWebServiceInvoker(WebServiceInvoker webServiceInvoker) {
		this.webServiceInvoker = webServiceInvoker;
		
	}
}
