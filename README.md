# chapter1 - 스프링 프레임워크 소개

- FixedDepositController.java   
  ```   
  예제 1-1. FixedDepositController 생성자가 FixedDepositService의 인스턴스를 만든다.
  
  예제 1-2. FixedDepositController를 스프링 빈으로 설정하기 위해 FixedDepositService에 대한 의존 관계를 생성자 인수로 받는다. (FixedDepositService 객체 전달)   
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
  ```   
