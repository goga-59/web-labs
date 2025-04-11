package ru.goga59.siteiknt.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.goga59.siteiknt.api.service.NewsService;
import ru.goga59.siteiknt.api.service.ProfessorService;
import ru.goga59.siteiknt.storage.model.NewsModel;
import ru.goga59.siteiknt.storage.model.ProfessorModel;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final ProfessorService professorService;
    private final NewsService newsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("content", "fragments/main");
        return "base";
    }

    @GetMapping("/news")
    public String news(Model model) {
        List<NewsModel> newsList = newsService.getAllNews();
        model.addAttribute("newsList", newsList);
        model.addAttribute("content", "fragments/news");
        return "base";
    }

    @GetMapping("/professors")
    public String professors(Model model) {
        List<ProfessorModel> professors = professorService.getAllProfessors();
        model.addAttribute("professors", professors);
        model.addAttribute("content", "fragments/professors");
        return "base";
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("content", "fragments/contacts");
        return "base";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("content", "admin/fragments/admin-main");
        return "admin/admin-base";
    }

}
