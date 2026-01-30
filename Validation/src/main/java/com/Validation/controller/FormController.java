package com.Validation.controller;

import com.Validation.model.UserProfile;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/profile")
    public String profileForm(Model model) {
        model.addAttribute("userProfile", new UserProfile());
        return "profile";
    }

    @PostMapping("/profile")
    public String submitProfile(@Valid @ModelAttribute("userProfile") UserProfile userProfile,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            return "profile";
        }
        model.addAttribute("userProfile", userProfile);
        return "profile-result";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
}
