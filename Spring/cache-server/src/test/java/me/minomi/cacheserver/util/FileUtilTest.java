package me.minomi.cacheserver.util;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-12.
 */
public class FileUtilTest {

    @Test
    public void getFileName() throws IOException {
        String filePath = FileUtil.getFileName("https://akamai.pizzahut.co.kr/images/products/pizza/P_RG_HK.jpg");
        assertEquals(FileUtil.BASE_PATH + "/akamai/pizzahut/co/kr/images/products/pizza/P_RG_HK.jpg", filePath);
    }
}