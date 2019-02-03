package me.minomi.ioc_study.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-04.
 */

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
