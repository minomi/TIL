package me.minho.movie_reservation.domain;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 14/09/2019.
 */

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * 금액과 관련된 다양한 계산을 구현하는 클래스
 * 왜 Long 이나 Integer 타입을 쓰지 않고 Money 라는 클래스를 사용하는가?
 *
 * 1. Money 라는 타입을 사용하면 저장하는 값이 금액과 관련돼 있다는 의미를 더욱 명확하게 전달할 수 있다.
 *      - 도메인의 의미를 더욱 풍부하게 표현
 * 2. 금액과 관련된 로직이 서로 다른 곳에 중복되어 구현되는 것을 막을 수 있다.
 *
 * 비록 하나의 변수만 포함하더라도, 의미를 좀 더 명시적이고 분명하게 표현할 수 있다면 객체를 사용해서 해당 개념을 구현하라.
 */

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Money {
    
    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    private static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

}
