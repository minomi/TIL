package me.minho.movie_reservation.domain;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 14/09/2019.
 */

import lombok.AllArgsConstructor;

/**
 * 영화 예매를 구현한 클래스
 */
@AllArgsConstructor
public class Reservation {
    /**
     * 예매한 고객
     */
    private Customer customer;
    /**
     * 예매한 상영
     */
    private Screening screening;
    /**
     * 얼마를 주고 예매했냐
     */
    private Money fee;
    /**
     * 인수 (좌석수)
     */
    private int audienceCount;
}
