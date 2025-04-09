package ru.goga59.siteiknt.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.goga59.siteiknt.storage.model.NewsModel;

public interface NewsRepository extends JpaRepository<NewsModel, Long> {
}
