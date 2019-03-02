package me.minomi.springmvcstudy.config;

import me.minomi.springmvcstudy.event.EventFilter;
import me.minomi.springmvcstudy.event.EventFormatter;
import me.minomi.springmvcstudy.event.EventInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.*;

import java.util.concurrent.TimeUnit;

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

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new EventFormatter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**")
                .addResourceLocations("classpath:/static/mobile/")
                .setCacheControl(CacheControl.maxAge(5, TimeUnit.SECONDS));
    }
}
