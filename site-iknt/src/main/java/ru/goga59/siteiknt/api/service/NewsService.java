package ru.goga59.siteiknt.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.goga59.siteiknt.storage.model.NewsModel;
import ru.goga59.siteiknt.storage.repository.NewsRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public List<NewsModel> getAllNews() {
        return newsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void deleteNewsById(Long id) {
        newsRepository.deleteById(id);
    }

    public NewsModel getNewsById(Long id) {
        return newsRepository.findById(id).orElseThrow(() -> new RuntimeException("Новость не найдена"));
    }

    public void addNews(NewsModel newsModel) {
        newsRepository.save(newsModel);
    }

    public void updateNews(NewsModel newsModel) {
        newsRepository.save(newsModel);
    }

}
