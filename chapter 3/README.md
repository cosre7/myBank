# 3. 빈 설정
## 3.2 빈 정의 상속
### 3.2.1 MyBank - 빈 정의 상속 예제
- FixedDepositDao와 PersonalBankDao 클래스는 DatabaseOperations 클래스에 의존한다.
```
예제 3-1. DatabaseOperations 빈에 의존하는 DAO 빈
```
- 애플리케이션의 여러 빈이 같은 설정 집합(프로퍼티, 생성자 인수)을 공유하면 다른 빈 정의의 부모 역할을 하는 빈 정의를 만ㄷ늘 수 있다.
