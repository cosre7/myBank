# 2. 스프링 프레임워크 기초
## 2.2 '인터페이스를 사용하는 프로그래밍' 설계 원칙
- FixedDepositController 클래스에는 FixedDepositService 클래스의 참조가 있고 FixedDepositService 클래스에는 FixedDepositDao 클래스의 참조가 있는 상황   
	-> 의존 중인 클래스가 의존 관계의 구체적인 클래스를 직접 참조   
	-> 두 클래스 사이에 `긴밀한 결합(coupling) 발생`   
	=> 의존 관계의 구현을 변경하기 위해서는 의존 중인 클래스도 변경해야한다!   
	     
- 자바 인터페이스 : 구현 클래스가 준수해야 하는 계약을 정의   
	-> 클래스가 의존 관계를 구현하는 인터페이스에 의존하면 해당 의존 관계의 구현을 변경해도 의존 중인 클래스를 변경할 필요가 없다.   
	-> 의존 중인 클래스가 의존 관계가 구현하는 인스턴스로 의존성을 만드는 설계 원칙 : `인터페이스를 사용하는 프로그래밍`
	
- 의존 관계 클래스가 구현하는 인터페이스 = 의존관계 인터페이스(dependency interface)   

### 2.2.1 '인터페이스를 사용하는 프로그래밍' 설계 방식 지원
- '인터페이스를 사용하는 프로그래밍' 설계 방식을 사용하기 위한 준비
	- 의존 관계에 구체적인 구현 클래스가 아닌 의존 관계 인터페이스를 참조하는 빈 클래스를 만든다.
	- 의존 중인 빈에 주입하고 싶은 구체적인 구현을 지정할 수 있는 <bean> 엘리먼트를 정의한다.
	
```   
예제 2-1. FixedDepositServiceImpl 클래스   

예제 2-2. applicationContext.xml - MyBank 애플리케이션의 XML 파일

```   

## 2.3 정적 팩토리 메서드나 인스턴스 팩토리 메서드를 사용해 빈 만들기
- 스프링 컨테이너는 인수가 없는 생성자 지원 여부에 상관없이 클래스의 인스턴스를 만들고 관리할 수 있다.
- 팩토리 클래스를 사용해 객체 인스턴스를 만드는 기존 자바 애플리케이션이 있다면, 스프링 컨테이너를 사용해 팩토리가 만든 객체를 관리할 수 있다.

### 2.3.1 정적 팩토리 메서드로 빈 초기화하기
```
예제 2-3. FixedDepositDaoFactory 클래스   
예제 2-4. FixedDepositDaoFactory 클래스를 사용하는 빈 정의   
예제 2-5. 정적 팩토리 메서드가 만든 객체 주입하기    
```   

### 2.3.2 인스턴스 팩토리 메서드를 호출해 빈 초기화하기
```
예제 2-6. FixedDepositDaoFactory 클래스   
예제 2-7. FixedDepositDaoFactory의 getFixedDepositDao 메서드를 호출하는 설정
```
- 정적 팩토리 메서드나 인스턴스 팩토리 메서드로 생성된 빈의 의존 관계를 설정하기 위해서는 의존 관계를 팩토리 메서드에 인수로 넘기거나 세터 기반의 DI를 사용해 주입할 수 있다.

```
예제 2-8. FixedDepositJdbcDao 클래스   
예제 2-9. FixedDepositDaoFactory 클래스   
예제 2-10. FixedDepositDaoFactory의 getFixedDepositDao 메서드를 호출하는 설정   
예제 2-11. FixedDepositDaoFactory의 getFixedDepositDao 메서드를 호출하고, 호출이 반환하는 FixedDepositJdbcDao 인스턴스의 databaseInfo 프로퍼티를 설정하는 빈 설정   
```

## 2.4 생성자 기반 DI
- 스프링에서 의존 관계 주입은 빈의 생성자나 세터 메서드에 인수를 넘기는 방식으로 이루어진다.
- 세터 기반 DI : 세터 메서드로 의존 관계를 주입하는 DI 기법
	- <property> 엘리먼트를 사용해 빈 의존 관계를 설정
- 생성자 기반 DI : 생성자 인수로 의존 관계를 전달하는 DI 기법

### 2.4.1 세터 기반 DI 다시 보기
```
예제 2-12. PersonalBankService 클래스   
예제 2-13. PersonalBankService 클래스와 의존 관계인 빈 정의
```

### 2.4.2 생성자 기반 DI
- 생성자 기반 DI 에서는 빈의 의존 관계를 빈 클래스 생성자의 인수로 전달한다.
```
예제 2-14. PersonalBankService 클래스
예제 2-15. PersonalBankService 빈 정의
```

### 생성자 기반 DI와 세터 기반 DI를 함께 사용하기
- 빈 클래스에 생성자와 세터 기반 DI 메커니즘이 함께 필요하다면 <constructor-arg>와 <property> 엘리먼트를 조합해 의존 관계를 주입할 수 있다.
```
예제 2-16. PersonalBankService 클래스
예제 2-17. 생성자와 세터 기반 DI를 섞어서 사용하기
```