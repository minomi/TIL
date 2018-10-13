package com.minomi.court.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 26..
 */

@Configuration
public class ServiceConfiguration {
    @Bean
    public ReservationService reservationService() {
        return new ReservationServiceImpl();
    }
}
