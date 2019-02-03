### Validation

##### 유효성 검사할 객체 정의

```java
public class Book {
    String title;

    String isbn;

    Integer price;
}
```

##### BookValidator 정의

```java
public class BookValidator implements Validator {

    private static final Pattern ISBN10_PATTERN =
            Pattern.compile("^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$");

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "not empty", "책의 이름은 공백일 수 없다..");

        Book book = (Book) o;
        if (book.getPrice() <= 0) {
            errors.rejectValue("price", "min price", "책의 가격은 음수일 수 없다..");
        }

        if (book.getPrice() > 10 * 1000 * 1000) {
            errors.rejectValue("price", "max price", "책의 가격은 상한선은 10억이다");
        }

        Matcher matcher = ISBN10_PATTERN.matcher(book.getIsbn());
        if (!matcher.find()) {
            errors.rejectValue("isbn", "isbn pattern", "책의 isbn-10 형식이 아님");
        }
    }
}
```

`supports` 메서드 에는 매개변수로 들어온 타입이 Validator 가 유효성을 검사할 클래스가 맞는지 판단하는 메서드

`validate` 는 유효성을 검사하는 로직이 들어가는 메서드

필드 별로 유효성을 검사후 error code 를 지정할 수 있고 default message 도 넣을 수 있다.


#### 검증
```java
@Component
public class ValidationAppRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Book book = Book.builder()
                .isbn("111")
                .price(-20)
                .title("")
                .build();

        Errors errors = new BeanPropertyBindingResult(book, "book");

        BookValidator bookValidator = new BookValidator();
        bookValidator.validate(book, errors);

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
        }
    }
}
``` 

일부러 유효성이 깨진 book 인스턴스를 만들고, error 들을 담을 인스턴스를 `BeanPropertyBindingResult` 타입으로 정의
 
> `BeanPropertyBindingResult` 는 `Error` 인터페이스의 구현체

이렇게 Validator 를 구현해서 유효성을 검증하는 방법도 있고, `Bean Validation` 의 구현체인 `hibernate-validator` 를 사용하여 검증하는 방법도 있음

```java
import javax.validation.constraints.*;

@Getter
@Builder
public class Book {
    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @Pattern(regexp = "^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")
    private String isbn;

    @Min(0)
    @Max(10 * 1000 * 1000)
    private Integer price;
}
```

```java
@Component
public class ValidationAppRunner implements ApplicationRunner {

    @Autowired
    Validator bookValidator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Book book = Book.builder()
                .isbn("111")
                .price(-20)
                .title("")
                .build();

        Errors errors = new BeanPropertyBindingResult(book, "book");

//        BookValidator bookValidator = new BookValidator();
        bookValidator.validate(book, errors);

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
        }
    }
}
```

스프링 부트 2.0.5 이상 버전을 사용한다면 `LocalValidatorFactoryBean` 빈으로 Autowired 된다.