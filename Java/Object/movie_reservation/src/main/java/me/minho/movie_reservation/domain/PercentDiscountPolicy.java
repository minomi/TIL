package me.minho.movie_reservation.domain;

import lombok.AllArgsConstructor;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 15/09/2019.
 */

@AllArgsConstructor
public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
