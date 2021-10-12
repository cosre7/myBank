# 3. 빈 설정
## 3.2 빈 정의 상속
### 3.2.1 MyBank - 빈 정의 상속 예제
- FixedDepositDao와 PersonalBankDao 클래스는 DatabaseOperations 클래스에 의존한다.
```
예제 3-1. DatabaseOperations 빈에 의존하는 DAO 빈
```
- 애플리케이션의 여러 빈이 같은 설정 집합(프로퍼티, 생성자 인수)을 공유하면 다른 빈 정의의 부모 역할을 하는 빈 정의를 만들 수 있다.
```
예제 3-2. applicationContext.xml - MyBank의 XML 파일
```
- 스프링 컨테이너는 추상 빈 정의에 해당하는 빈을 생성하지 않는다.
- 추상 빈에 의존하는 빈을 정의할 수 없다. -> 추상 빈을 참조하는 \<property> 나 \<constructor-arg> 엘리먼트를 사용할 수 없다.
- 부모 빈 정의가 class 속성을 지정하지 않으면, 자식 빈 정의가 class 속성을 정의한다.
- class 속성을 지정하지 않는 빈은 꼭 추상 빈으로 만들어야 스프링 컨테이너가 그 빈 인스턴스를 생성하지 않는다.

### 3.2.2 상속할 수 있는 정보는?
- 부모 빈 정의에서 자식 빈 정의로 상속할 수 있는 정보
	```
	- 프로퍼티 - <property> 엘리먼트로 설정
	- 생성자 인수 - <constructor-arg> 엘리먼트로 설정
	- 메서드 오버라이드
	- 초기화와 정리 메서드
	- 팩토리 메서드 - <bean> 엘리먼트의 factory-method 속성을 설정
	```