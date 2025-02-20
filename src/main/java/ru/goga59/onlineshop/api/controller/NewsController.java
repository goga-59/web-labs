package ru.goga59.onlineshop.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.goga59.onlineshop.api.service.NewsService;
import ru.goga59.onlineshop.storage.model.NewsModel;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/")
    public String toNewsPage(Model model) {
        List<NewsModel> newsList = newsService.getAllNews();
        model.addAttribute("newsList", newsList);
        return "news";
    }

}
