package ru.goga59.onlineshop.api.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(Model model, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("main_page");
        model.addAttribute("content", "404");
        modelAndView.addObject("title", "Ошибка 404");
        return modelAndView;
    }

}
