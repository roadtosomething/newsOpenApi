package com.just_talk.news.repository;

import com.just_talk.news.model.NewsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewsRepository extends JpaRepository<NewsModel, Integer> {
    @Query(value = "select nextval('news_id_seq')", nativeQuery = true)
    int getNextValueSequence();
}
