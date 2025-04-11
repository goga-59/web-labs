package ru.goga59.siteiknt.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.goga59.siteiknt.api.service.NewsService;
import ru.goga59.siteiknt.storage.model.NewsModel;

@Controller
@RequiredArgsConstructor
@RequestMapping ("/admin/news")
public class AdminNewsController {

    private final NewsService newsService;

    @GetMapping
    public String adminNews(Model model) {
        model.addAttribute("newsList", newsService.getAllNews());
        model.addAttribute("content", "admin/fragments/admin-news");
        return "admin/admin-base";
    }

    @GetMapping("/edit/{id}")
    public String editNewsForm(@PathVariable Long id, Model model) {
        NewsModel news = newsService.getNewsById(id);
        model.addAttribute("news", news);
        return "admin/crud/news-edit";
    }

    @PostMapping("/edit")
    public String saveNewsEdit(@ModelAttribute NewsModel news) {
        newsService.updateNews(news);
        return "redirect:/admin/news";
    }

    @GetMapping("/delete/{id}")
    public String deleteNews(@PathVariable long id) {
        newsService.deleteNewsById(id);
        return "redirect:/admin/news";
    }

    @GetMapping("/add")
    public String addNews(Model model) {
        NewsModel news = new NewsModel();
        model.addAttribute("news", news);
        return "admin/crud/news-add";
    }

    @PostMapping("/add")
    public String addNews(@ModelAttribute NewsModel news) {
        newsService.addNews(news);
        return "redirect:/admin/news";
    }

}
