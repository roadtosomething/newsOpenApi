package com.just_talk.news.repository;

import com.just_talk.news.model.NewsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsModel, Integer> {

}
