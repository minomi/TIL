package me.minomi.springbootjounal.controllers;

import me.minomi.springbootjounal.services.JournalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-03-01.
 */

@Controller
public class JournalController {

    private JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("journals", journalService.findAllJournals());
        return "index";
    }
}
