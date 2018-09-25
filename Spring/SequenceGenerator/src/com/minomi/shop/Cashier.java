package com.minomi.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.Date;
import java.util.Locale;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 25..
 */

@Component
public class Cashier {

    @Autowired
    private MessageSource messageSource;

    @Value("checkout")
    private String fileName;

    @Value("src/com/minomi/shop/cashier")
    private String path;

    private BufferedWriter writer;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @PostConstruct
    public void openFile() throws IOException {
        File targetDir = new File(path);

        if (!targetDir.exists()) {
            targetDir.mkdir();
        }

        File checkoutFile = new File(path, fileName + ".txt");

        if (!checkoutFile.exists()) {
            checkoutFile.createNewFile();
        }

        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(checkoutFile, true)));
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void checkout(ShoppingCart cart) throws IOException {
        writer.write(new Date() + "\t" + cart.getItems() + "\r\n");
        writer.flush();
    }

    @PreDestroy
    public void closeFile() throws IOException {
        writer.close();
    }
}
