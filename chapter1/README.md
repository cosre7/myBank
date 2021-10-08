# chapter1 - ������ �����ӿ�ũ �Ұ�

- FixedDepositController.java   
  ```   
  ���� 1-1. FixedDepositController �����ڰ� FixedDepositService�� �ν��Ͻ��� �����.
  
  ���� 1-2. FixedDepositController�� ������ ������ �����ϱ� ���� FixedDepositService�� ���� ���� ���踦 ������ �μ��� �޴´�. (FixedDepositService ��ü ����)   
  
  ���� 1-12. FixedDepositController Ŭ����
  ```   
     
- servlet-context.xml   
  ```   
  ���� 1-3. XML ������ ���� ��Ÿ������   
  ```
       
- FixedDepositService   
  ```   
  ���� 1-4. FixedDepositService Ŭ���� - ���� ������ ���� ������ �����ؼ� �������� �޼��带 �����ϴ� POJO Ŭ����   
  
  ���� 1-5. JDBC Connection ��ü�� ����� Ʈ����� ���� ����   
  
  ���� 1-6. @Transactional �ֳ����̼� ���   
  
  ���� 1-7. ���� �߰�   
  
  ���� 1-8. active �÷��� �߰�   
  
  ���� 1-9. ������ JMX ���� ���   
  
  ���� 1-10. JMS �޽����� ������ FixedDepositService   
  
  ���� 1-11. ���� ������ �� ������ ĳ���ϴ� FixedDepositService     
  ```   

## 1.5 ������ ������ ���ø����̼�
	������ DI ����� ����ϱ� ���� �ܰ�
	1. ���ø����̼ǿ� ���̴� ���� ��ü�� ��ü �� ���� ���踦 �ľ��Ѵ�.
	2. 1�ܰ迡�� �ľ��� �� ���ø����̼ǿ� �����ϴ� POJO Ŭ������ �����.
	3. ���ø����̼� ��ü �� ���� ���踦 ǥ���ϴ� ���� ��Ÿ�����͸� �����.
	4. ������ IoC �����̳��� �ν��Ͻ��� ����� ���� ��Ÿ�����͸� �ν��Ͻ��� �����Ѵ�.
	5. ������ IoC �����̳� �ν��Ͻ��� ���ø����̼� ��ü�� �����Ѵ�.
	
### 1.5.3 ���� ��Ÿ������ �����   
- ���ø����̼� ���� ��Ÿ�����͸� XML �������� �����Ϸ��� ���ø����̼� ��ü�� ��ü �� �������谡 ����ִ� ���ø����̼� ���ؽ�Ʈxml ������ ������ �Ѵ�.   

- applicationContext.xml   
```   
���� 1-13. applicationContext.xml - myBank ���ø����̼��� XML ����   
```   

- FixedDepositController   
```   
���� 1-14. FixedDepositController Ŭ����   
```

- ������ �����̳ʴ� ���� ����� �� applicationContext.xml ���Ͽ��� �����ϴ� ���� ��Ÿ�����͸� �а� �����Ѵ�.
- �� ���� ���� = applicationContext.xml ���Ͽ� ���� ���ǵ� ����
		
### 1.5.5 ������ �����̳� �ν��Ͻ� �����   
- ������ ApplicationContext ��ü�� ������ �����̳� �ν��Ͻ��� ǥ���Ѵ�.   
- �������� ClassPathXmlApplicationContext, FileSystemXmlApplicationContext, XmlWebApplicationContext �� �� ���� ApplicationContext �������̽� ������ �����Ѵ�.   
	-> � ApplicationContext�� �����ϴ��Ĵ� ���� ��Ÿ�������� ���� ���(XML, �ֳ����̼�, �ڹ� �ڵ� ��)�� ���ø����̼��� ����(�� �Ǵ� ���� ����)�� ���� �޶�����.   
	
- ClassPathXmlApplicationContext, FileSystemXmlApplicationContext : ���� ��Ÿ�����͸� XML ���·� ������ ���� ���� ���ø����̼ǿ� ����   
- XmlWebApplicationContext : ���� ��Ÿ�����͸� XML ���·� ������ �� ���ø���ġ�ǿ� ����   
- AnnotationConfigWebApplicationContext : �ڹ� �ڵ带 ���� ���� ��Ÿ�����͸� �����ϴ� �� ���ø����̼ǿ� ����      

```
���� 1-15 BankApp Ŭ����   
```       

- MyBank ���ø����̼��� applicationContext.xml�� ���ǵ� ���� �̱��� �������̸� ����-�ν��Ͻ�ȭ�� �����Ǿ���.   
	-> applicationContext.xml�� ���ǵ� ���� ClassPathXmlApplicationContext�� �ν��Ͻ�ȭ�� �� �����ȴٴ� ��
	
### 1.5.6 ������ �����̳ʿ� �ִ� �� �����ϱ�
- <bean> ������Ʈ�� ���� ���ǵ� ���ø����̼� ��ü�� ������ �����̳ʷ� ����, �����Ѵ�.   
```   
���� 1-16. BankApp Ŭ����   
```   