package kr.co.hanbit.mastering.springmvc4.config;

import kr.co.hanbit.mastering.springmvc4.date.KRLocalDateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

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

    // SessionLocaleResolver 는 HTTP 세션에서 지역정보를 찾고 저장한다.
    @Bean
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    // 컨트롤러에 전달되는 요청을 가로채고, lang 쿼리 파라미터를 점검할 수 있음.
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
