package me.minomi.ioc_study.validation;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-04.
 */
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
