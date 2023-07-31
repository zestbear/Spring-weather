package com.spring.weather.web;

import com.spring.weather.config.auth.LoginUser;
import com.spring.weather.config.auth.dto.SessionUser;
import com.spring.weather.domain.List.ListsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ListsRepository listsRepository;
    private final com.spring.weather.service.ListsService listsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("lists", listsRepository.findAllByOrderByIdDesc());

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
    public String show(Model model, @LoginUser SessionUser user) {

        model.addAttribute("lists", listsRepository.findAllByOrderByIdDesc());

        if(user != null) {
            model.addAttribute("User", user.getName());
        }

        return "weather";
    }

}
