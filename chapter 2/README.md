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

## 2.5 설정 정보를 빈에 전달하기
- 전자우편 인증에 필요한 서버 주소, 사용자 이름, 암호가 있는 EmailMessageSender 클래스
```
예제 2-18. EmailMessageSender 클래스와 빈 정의 - 세터 기반 DI
예제 2-19. EmailMessageSender 클래스와 빈 정의 - 생성자 기반 DI
```

## 2.6 빈 스코프
- 빈을 공유하기 위한 인스턴스를 단 하나만 만드는 경우(싱글턴 스코프), 빈이 요청될 때마다 새로운 빈 인스턴스 생성(프로토타입 스코프)여부를 제어하기 위해 빈의 스코프를 지정할 수 있다.
- 빈의 스코프는 <bean> 엘리먼트의 `scope` 속성을 사용해 정의한다.
- `scope`를 지정하지 않으면 그 빈은 싱글턴 스코프로 지정   
    
- 웹에서 사용하는 스코프
	- request
	- session
	- websocket
	- application
- 스코프는 빈 인스턴스의 수명을 결정

### 2.6.1 싱글턴
- 싱글턴 스코프(Singleton scope)는 XML 파일에 정의된 모든 빈의 디폴트 스코프
- 싱글턴 스코프 빈의 인스턴스는 스프링 컨테이너가 생성될 때 함께 생성되고, 스프링 컨테이너가 파괴될 때 함께 파괴된다
- 스프링 컨테이너는 싱글턴 스코프 빈의 인스턴스를 하나 만들고 그 빈에 의존하는 모든 빈에 유일한 인스턴스를 공유한다.
```
예제 2-20. applicationContext.xml - 싱글턴 스코프 빈   
예제 2-21. SingletonTest - JUnit 테스트 클래스
```
- 싱글턴 스코프 빈 인스턴스는 그 빈에 의존하는 모든 빈 사이에서 공유된다.
```
예제 2-22. SingletonTest JUnit 테스트 클래스의 testReference 메서드
```
- 싱글턴 스코프 빈에 의존하는 빈이 여럿 있다면 그 모든 빈이 똑같은 싱글턴 스코프 빈 인스턴스를 공유한다.

### 여러 스프링 컨테이너에 있는 싱글턴 스코프 빈
- 싱글턴 스코프 빈 인스턴스의 존재 범위는 한 스프링 컨테이너 인스턴스 내부로 제한
- 똑같은 설정 메타데이터로부터 2개의 스프링 컨테이너를 만들면 각 스프링 컨테이너마다 자신만의 싱글턴 빈 인스턴스를 갖는다.
```
예제 2-23. SingletonTest JUnit 테스트 클래스의 testSingletonScope 메서드    
예제 2-24. 같은 클래스에 여러 빈 정의가 있는 applicationContext.xml
예제 2-25. SingletonTest JUnit 테스트 클래스의 testSingletonScopePerBeanDef 메서드
```
- 빈 정의마다 하나씩 싱글턴 스코프 빈이 생성된다.
- 스프링 컨테이너가 인스턴스를 생성할 때 싱글턴 스코프 빈의 인스턴스도 생성된다.

### 싱글턴 스코프 빈을 지연 생성하기
- 스프링 컨테이너에 싱글턴 빈을 처음으로 요청받았을 때 인스턴스를 생성하라고 지시할 수도 있다.
```
예제 2-26. 싱글턴 빈 지연 생성하기
```
- 지연 초기화로 설정된 싱글턴 빈의 인스턴스는 애플리케이션이 그 빈을 처음 요청할 때 생성
- 지연초기화로 설정하지 않은 싱글턴 빈의 인스턴스는 스프링 컨테이너가 생성될 때 인스턴스화
- 스프링 컨테이너가 싱글턴 빈을 미리 초기화하거나 지연 초기화할 수 있기 때문에 싱글턴 빈을 모두 지연 초기화하거나 미리 초기화해야겠다고 생각할수도 
	-> 대부분의 애플리케이션 시나리오에서는 문제를 발견하기 위해 싱글턴 빈을 미리 초기화

### 2.6.2 프로토타입
- 프로토타입 스코프(prototype scope) 빈이 싱글턴 스코프 빈과 다른 점은 스프링 컨테이너가 항상 프로토타입 스코프 빈의 새로운 인스턴스를 반환한다는 점이다.
- 프로토타입 빈은 항상 지연초기화 된다.
```
예제 2-28. 프로토타입 스코프 빈 예제 applicationContext.xml   
예제 2-29. PrototypeTest JUnit 테스트 클래스의 testinstances 메서드
```

### 2.6.3 빈에 적합한 스코프 선택하기
- 빈이 어떤 대화적 상태도 유지하지 않는다면(stateless 빈) 싱글턴 스코프 빈으로 정의
- 빈에 대화적 상태를 유지해야 한다면 프로토타입 스코프 빈으로 정의