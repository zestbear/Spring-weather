package com.spring.weather.web;

import com.spring.weather.config.auth.LoginUser;
import com.spring.weather.config.auth.dto.SessionUser;
import com.spring.weather.domain.List.ListsRepository;
import com.spring.weather.sevice.ListsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ListsRepository listsRepository;
    private final ListsService listsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", listsRepository.findAllDesc());

        if(user != null) {
            model.addAttribute("User", user.getName());
        }

        return "index";
    }

    @GetMapping("/weather/login")
    public String login() {
        return "login";
    }

    @GetMapping("/weather")
    public String show() {
        return "weather";
    }
}
