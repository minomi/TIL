#### JPA 의 데이터 타입

JPA 의 데이터 타입을 크게 분류 하면 `값 타입`, `엔티티 타입` 으로 나눌 수 있음 <br>

##### 엔티티 타입
`@Entity` 로 정의하는 객체

##### 값 타입
* 자바의 기본 값 타입, 래퍼 클래스 (int, Integer, String)
* 임베디드 타입
* 컬렉션 값 타입

###### 임베디드 타입 (복합 값 타입)

엔티티내에서 코드를 더 객체지향적으로 설계하기 위해, 엔티티의 응집력을 높이기 위해 의미있는 기본값들을 모아서 하나의 타입으로 정의 한 타입

employee 테이블을 매핑한 Employee 엔티티

```Java
@Entity
public class Employee {
    @Id @GeneratedValue
    private Long id;
    private String name;
    
    // 근무 기간 관련 데이터
    @Temporal(TemporalType.DATE)
    private Date startTime;
    @Temporal(TemporalType.DATE)
    private Date endTime;
    
    // 주소 관련 데이터
    private String city;
    private String street;
    private String zipCode;
}
```

임베디드 타입을 사용해 서로 관련이 있는 근무 기간 데이터들, 주소 관련 데이터 들을 모아 <br> 
Period 타입, Address 타입 으로 만들 수 있음 

```java
@Embeddable
public class Period {
    @Temporal(TemporalType.DATE)
    private Date startTime;
    @Temporal(TemporalType.DATE)
    private Date endTime;
    
    public boolean isWork(Date date) {
        // 메서드도 정의 가능
    }
}
```

```java
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipCode;
}
```

```java
@Entity
public class Employee {
    @Id @GeneratedValue
    private Long id;
    private String name;
        
    @Embedded
    private Period workPeriod;
    @Embedded
    private Address address;
}
```

`@Embeddable` : 복합 값 타입을 정의하겠다!!! 할 때 사용하는 어노테이션 
`@Embedded` : 복합 값 타입을 사용하겠다!!! 할 때 사용하는 어노테이션

`Address` 클래스와 `Period` 클래스는 다른 엔티티에서 재사용도 가능하고, 임베디드 타입 안에서 다른 임베디드 타입을 참조할 수 있다.


###### 한 엔티티에서 여러개의 같은 임베디드 타입 사용하기 : @AttributeOverride
Employee 엔티티의 회사주소, 집주소를 표현하고 싶다면??
```java
public class Employee {
    // ...
    
    @Embedded
    private Address companyAddress;
    @Embedded
    private Address homeAddress;

    // ...
}
```

이런식으로 할 수 있겠지만 Address 타입의 city, street, zipCode 컬럼명이 중복될 것이다. <br>
`@AttributeOverride` 애노테이션을 사용하면 매핑정보를 재정의 할 수 있다.

```java
public class Employee {
    // ...
    @Embedded
    private Address companyAddress;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="city", column=@Column(name = "HOME_CITY")),
        @AttributeOverride(name="street", column=@Column(name = "HOME_STREET")),
        @AttributeOverride(name="zipCode", column=@Column(name = "HOME_ZIP_CODE")),
    })
    private Address homeAddress;
}
``` 

###### 값 타입 (Value Object) 은 불변 객체 (Immutable Object) 로 설계 하자
임베디드 타입 처럼 기본 값 타입이 아닌 JPA 의 값 타입은 불변 객체로 설계하여 값이 수정되어 생기는 부작용을 막자.
```java
Address address = new Address("Seoul", "Gangnam", "113232");
employee.setAddress(address); // 값 타입인 address 를 employee 에 저장  

address.setCity("Busan"); 
anotherEmployee.setAddress(address); // address 의 city 만 변경해서 또 다른 엔티티인 anothorEmployee 에 저장
```
employee 에는 Seoul 이, anotherEmployee 에는 Busan 이 저장되기를 기대했지만, 둘 다 Busan 이 저장됨.

Address 를 불변 객체로 만들어 한번 생성이 되면 변경되지 않게 하자.
> 불변 객체 : 객체의 인스턴스가 생성이 되면 인스턴스의 내부가 절대 변하지 않는 객체
> 생성자로만 생성가능하게 하고 setter 같은 내부의 프로퍼티를 수정하는 메서드를 작성하지 않으면 불변 객체로 만들 수 있다.

###### 동등성 비교를 위해 equals 메서드를 오버라이딩하자.
HashMap 이나 HashSet 같이 hashCode() 를 사용하는 자료구조를 위해 hashCode() 도 같이 오버라이딩 해주면 좋다.


