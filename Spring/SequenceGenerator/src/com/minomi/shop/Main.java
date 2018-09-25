package com.minomi.shop;

import com.minomi.shop.config.ShopConfiguration;
import com.minomi.shop.domain.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Date;
import java.util.Locale;
import java.util.Properties;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 23..
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);

        ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
        cart1.addItem(aaa);
        cart1.addItem(cdrw);
        System.out.println("Shopping cart 1 contains" + cart1.getItems());

        ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);
        cart2.addItem(dvdrw);
        System.out.println("Shopping cart 2 contains" + cart2.getItems());

        Resource resource = new ClassPathResource("com/minomi/shop/discounts.properties");
        Properties props = PropertiesLoaderUtils.loadProperties(resource);

        System.out.println("And don't forget out discounts");
        System.out.println(props);

        Cashier cashier = context.getBean("cashier", Cashier.class);
        cashier.checkout(cart1);
        cashier.checkout(cart2);
    }
}
