package me.minomi.springbootjounal.controllers;

import me.minomi.springbootjounal.domain.Journal;
import me.minomi.springbootjounal.persistance.JournalRepository;
import me.minomi.springbootjounal.services.JournalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-01.
 */

@RunWith(SpringRunner.class)
@WebMvcTest
public class JournalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JournalService journalService;

    @Test
    public void indexTest() throws Exception {
        Journal mockJournal = Journal.builder()
                .title("난 테스트용 일기야")
                .createdDate(LocalDateTime.now())
                .summary("난 테스트용이다.")
                .build();

        given(journalService.findAllJournals()).willReturn(Collections.singletonList(mockJournal));

        mockMvc.perform(get("/"))
                .andExpect(model().attributeExists("journals"))
                .andExpect(model().attribute("journals", contains(mockJournal)))
                .andExpect(view().name("index"));
    }

}