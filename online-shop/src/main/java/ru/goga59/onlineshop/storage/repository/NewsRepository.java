package ru.goga59.onlineshop.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.goga59.onlineshop.storage.model.NewsModel;

public interface NewsRepository extends JpaRepository<NewsModel, Long> {
}
