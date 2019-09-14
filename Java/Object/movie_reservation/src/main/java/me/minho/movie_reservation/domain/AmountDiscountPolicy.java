package me.minho.movie_reservation.domain;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 15/09/2019.
 */

import lombok.AllArgsConstructor;

/**
 * 할인 조건을 만족하면 일정한 금액을 할인 해줌
 */
@AllArgsConstructor
public class AmountDiscountPolicy extends DiscountPolicy {

    private Money discountAmount;

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
