# chapter1 - 스프링 프레임워크 소개

- FixedDepositController.java   
  ```   
  예제 1-1. FixedDepositController 생성자가 FixedDepositService의 인스턴스를 만든다.
  
  예제 1-2. FixedDepositController를 스프링 빈으로 설정하기 위해 FixedDepositService에 대한 의존 관계를 생성자 인수로 받는다. (FixedDepositService 객체 전달)   
  
  예제 1-12. FixedDepositController 클래스
  ```   
     
- servlet-context.xml   
  ```   
  예제 1-3. XML 형태의 설정 메타데이터   
  ```
       
- FixedDepositService   
  ```   
  예제 1-4. FixedDepositService 클래스 - 정기 예금의 세부 사항을 생성해서 가져오는 메서드를 정의하는 POJO 클래스   
  
  예제 1-5. JDBC Connection 객체를 사용해 트랜잭션 직접 관리   
  
  예제 1-6. @Transactional 애너테이션 사용   
  
  예제 1-7. 보안 추가   
  
  예제 1-8. active 플래그 추가   
  
  예제 1-9. 스프링 JMX 지원 사용   
  
  예제 1-10. JMS 메시지를 보내는 FixedDepositService   
  
  예제 1-11. 정기 예금의 상세 정보를 캐시하는 FixedDepositService     
  ```   

## 1.5 간단한 스프링 애플리케이션
	스프링 DI 기능을 사용하기 위한 단계
	1. 애플리케이션에 쓰이는 여러 객체와 객체 간 의존 관계를 파악한다.
	2. 1단계에서 파악한 각 애플리케이션에 상응하는 POJO 클래스를 만든다.
	3. 애플리케이션 객체 간 의존 관계를 표현하는 설정 메타데이터를 만든다.
	4. 스프링 IoC 컨테이너의 인스턴스를 만들고 설정 메타데이터를 인스턴스에 전달한다.
	5. 스프링 IoC 컨테이너 인스턴스로 애플리케이션 객체에 접근한다.
	
### 1.5.3 설정 메타데이터 만들기   
- 애플리케이션 설정 메타데이터를 XML 형식으로 제공하려면 애플리케이션 객체와 객체 간 의존관계가 들어있는 애플리케이션 컨텍스트xml 파일을 만들어야 한다.   

- applicationContext.xml   
```   
예제 1-13. applicationContext.xml - myBank 애플리케이션의 XML 파일   
```   

- FixedDepositController   
```   
예제 1-14. FixedDepositController 클래스   
```

- 스프링 컨테이너는 빈을 만들기 전 applicationContext.xml 파일에서 제공하는 설정 메타데이터를 읽고 검증한다.
- 빈 생성 순서 = applicationContext.xml 파일에 빈이 정의된 순서
		
### 1.5.5 스프링 컨테이너 인스턴스 만들기   
- 스프링 ApplicationContext 객체는 스프링 컨테이너 인스턴스를 표현한다.   
- 스프링은 ClassPathXmlApplicationContext, FileSystemXmlApplicationContext, XmlWebApplicationContext 등 몇 가지 ApplicationContext 인터페이스 구현을 제공한다.   
	-> 어떤 ApplicationContext를 선택하느냐는 설정 메타데이터의 정의 방법(XML, 애너테이션, 자바 코드 등)과 애플리케이션의 유형(웹 또는 독립 실행)에 따라 달라진다.   
	
- ClassPathXmlApplicationContext, FileSystemXmlApplicationContext : 설정 메타데이터를 XML 형태로 정의한 독립 실행 애플리케이션에 적합   
- XmlWebApplicationContext : 설정 메타데이터를 XML 형태로 정의한 웹 애플리케치션에 적합   
- AnnotationConfigWebApplicationContext : 자바 코드를 통해 설정 메타데이터를 정의하는 웹 애플리케이션에 적합      

```
예제 1-15 BankApp 클래스   
```       

- MyBank 애플리케이션의 applicationContext.xml에 정의된 빈은 싱글턴 스코프이며 사전-인스턴스화로 설정되었다.   
	-> applicationContext.xml에 정의된 빈이 ClassPathXmlApplicationContext가 인스턴스화될 때 생성된다는 뜻
	
### 1.5.6 스프링 컨테이너에 있는 빈에 접근하기
- <bean> 엘리먼트를 통해 정의된 애플리케이션 객체는 스프링 컨테이너로 생성, 관리한다.   
```   
예제 1-16. BankApp 클래스   
```   