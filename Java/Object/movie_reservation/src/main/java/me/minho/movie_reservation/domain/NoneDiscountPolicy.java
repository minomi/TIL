package me.minho.movie_reservation.domain;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 15/09/2019.
 */
public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
