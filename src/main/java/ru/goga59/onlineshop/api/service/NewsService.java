package ru.goga59.onlineshop.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.goga59.onlineshop.storage.model.NewsModel;
import ru.goga59.onlineshop.storage.repository.NewsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public List<NewsModel> getAllNews() {
        return newsRepository.findAll();
    }

}
