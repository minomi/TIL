package me.minho.movie_reservation.domain;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 14/09/2019.
 */

import java.time.LocalDateTime;

/**
 * 사용자들의 예매하는 대상인 '상영'을 구현
 */
public class Screening {
    /**
     * 상영할 영화
     */
    private Movie movie;
    /**
     * 순번
     */
    private int sequence;
    /**
     * 상영 시작 시간
     */
    private LocalDateTime whenScreened;

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

}
