package ru.goga59.onlineshop.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    @GetMapping("/info")
    public String goToInfo() {
        return "info";
    }

}
