package me.minho.movie_reservation.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 15/09/2019.
 */
public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ...conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    /**
     * 상영의 할인 가격을 계산을 자식 클래스에게 위임한다. (TEMPLATE METHOD PATTERN)
     * @param screening 영화 상영
     * @return
     */
    protected abstract Money getDiscountAmount(Screening screening);
}
