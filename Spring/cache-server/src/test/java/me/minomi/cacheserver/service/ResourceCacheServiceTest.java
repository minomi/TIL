package me.minomi.cacheserver.service;

import me.minomi.cacheserver.components.MemCacheQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-01-12.
 */

@RunWith(SpringRunner.class)
@WebMvcTest({ResourceCacheService.class, MemCacheQueue.class})
public class ResourceCacheServiceTest {

    @Autowired
    private ResourceCacheService resourceCacheService;

    @Test
    public void getCache() {
        String resourceURL = "";
        File file = resourceCacheService.getResource(resourceURL);
        assertFalse(file.exists());
    }

}