package kr.co.hanbit.mastering.springmvc4.config;

import kr.co.hanbit.mastering.springmvc4.date.KRLocalDateFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.LocalDate;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 17..
 */

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDate.class, new KRLocalDateFormatter());
    }
}
