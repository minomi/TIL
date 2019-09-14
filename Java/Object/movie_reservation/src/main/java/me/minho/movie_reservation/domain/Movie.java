package me.minho.movie_reservation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 14/09/2019.
 */

@AllArgsConstructor
public class Movie {
    private String title;
    private Duration runningTime;
    @Getter
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
