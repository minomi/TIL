package me.minomi.springmvcstudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.CacheControl;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-24.
 */

@RunWith(SpringRunner.class)
@WebMvcTest
public class SimpleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(post("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void urlMappingTest() throws Exception {
        mockMvc.perform(get("/hello/minho"))
                .andDo(print())
                .andExpect(handler().handlerType(SimpleController.class))
                .andExpect(handler().methodName("helloRegexName"));
    }

    @Test
    public void staticResourceHandlerCacheControlTest() throws Exception {
        mockMvc.perform(get("/mobile/index.html"))
                .andDo(print())
                .andExpect(header().exists("Cache-Control"));
    }

}