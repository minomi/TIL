package com.minomi.shop.config;

import com.minomi.shop.BannerLoader;
import com.minomi.shop.Cashier;
import com.minomi.shop.domain.Battery;
import com.minomi.shop.domain.Disc;
import com.minomi.shop.domain.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 23..
 */

@Configuration
@PropertySource("classpath:com/minomi/shop/discounts.properties")
@ComponentScan("com.minomi.shop")
public class ShopConfiguration {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:com/minomi/shop/messages");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }

    @Value("classpath:com/minomi/shop/banner.txt")
    private Resource banner;

    @Value("${endofyear.discount:0}")
    private double specialEndofyearDiscountField;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public BannerLoader bannerLoader() {
        BannerLoader b1 = new BannerLoader();
        b1.setBanner(banner);
        return b1;
    }

    @Bean
    public Product aaa() {
        Battery p1 = new Battery("AAA", 2.5);
        p1.setRechargeable(true);
        return p1;
    }

    @Bean
    public Product cdrw() {
        Disc p2 = new Disc("CD-RW", 1.5);
        p2.setCapacity(700);
        return p2;
    }

    @Bean Product dvdrw() {
        Disc p2 = new Disc("DVD-RW", 3.0);
        p2.setCapacity(700);
        return p2;
    }

}
