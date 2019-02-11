package me.minomi.springmvcstudy.config;

import me.minomi.springmvcstudy.event.EventFilter;
import me.minomi.springmvcstudy.event.EventInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-10.
 */

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new EventInterceptor())
                .addPathPatterns("/events");
    }

    @Bean
    public FilterRegistrationBean<EventFilter> eventFilter() {
        FilterRegistrationBean<EventFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new EventFilter());
        filterRegistrationBean.addUrlPatterns("/events/*");
        return filterRegistrationBean;
    }

}
