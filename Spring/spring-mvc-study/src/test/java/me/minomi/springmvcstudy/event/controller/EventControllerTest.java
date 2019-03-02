package me.minomi.springmvcstudy.event.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.minomi.springmvcstudy.event.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest
public class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void event() throws Exception {
        mockMvc.perform(get("/event/hot"))
                .andDo(print())
                .andExpect(content().string("hot event"));
    }

    @Test
    public void eventJson() throws Exception {
        final Event event = new Event();
        event.setIdx(1);
        event.setName("First");
        final String jsonEvent = objectMapper.writeValueAsString(event);

        mockMvc.perform(get("/eventJson")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(jsonEvent))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().string(jsonEvent));
    }
}