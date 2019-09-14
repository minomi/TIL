package me.minho.movie_reservation.domain;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 15/09/2019.
 */

import lombok.AllArgsConstructor;

/**
 * 영화 상영 순번이 특정 순번이면 할인 해줌
 */

@AllArgsConstructor
public class SequenceCondition implements DiscountCondition {

    private int sequence;

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
