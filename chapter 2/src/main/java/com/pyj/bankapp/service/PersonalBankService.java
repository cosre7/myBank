package com.pyj.bankapp.service;

/*
 * ���� ���� ���� ��������, ���� ���� �� ���� ���캸��, ����ó �����ϱ�, ��ȣ �����ϱ�, �� ���� �����ϱ�
 * ���� ���񽺸� ������.
 * */
public class PersonalBankService {
	private JmsMessageSender jmsMessageSender; // JMS �޽��� ����
	private EmailMessageSender emailMessageSender; // ���ڿ��� ����
	private WebServiceInvoker webServiceInvoker; // �ܺ� �� ���� ȣ��
	
	// �����ڰ� ��ü�� �μ��� �޴´�.
	public PersonalBankSercie(JmsMessageSender jmsMessageSender,
							  EmailMessageSender emailMessageSender,
							  WebServiceInvoker webServiceInvoker) {
		
		this.jmsMessageSender = jmsMessageSender;
		this.emailMessageSender = emailMessageSender;
		this.webServiceInvoker = webServiceInvoker;
	}
	
}
