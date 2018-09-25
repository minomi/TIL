package com.minomi.shop;

import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 25..
 */
public class BannerLoader {

    private Resource banner;

    public void setBanner(Resource banner) {
        this.banner = banner;
    }

    @PostConstruct
    public void showBanner() throws IOException {
        Files.lines(Paths.get(banner.getURI()), Charset.forName("UTF-8"))
                .forEachOrdered(System.out::println);
    }
}
