package kr.co.hanbit.mastering.springmvc4.controller;

import kr.co.hanbit.mastering.springmvc4.date.KRLocalDateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 16..
 */

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String displayProfile(ProfileForm profileForm) {
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile", params = {"save"}, method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "profile/profilePage";
        }
        return "redirect:/profile";
    }

    @RequestMapping(value = "/profile", params = {"addTaste"})
    public String addRow(ProfileForm profileForm) {
        profileForm.getTastes().add(null);
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile", params = {"removeTaste"})
    public String removeRow(ProfileForm profileForm, HttpServletRequest request) {
        Integer rowID = Integer.valueOf(request.getParameter("removeTaste"));
        profileForm.getTastes().remove(rowID.intValue());
        return "profile/profilePage";
    }

    @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale) {
        return KRLocalDateFormatter.getPattern(locale);
    }
}
