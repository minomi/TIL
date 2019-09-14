package me.minho.movie_reservation.domain;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 15/09/2019.
 */
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
