package com.just_talk.news.service;

import com.just_talk.news.dto.NewsDTO;
import com.just_talk.news.model.NewsModel;

import java.util.*;

public interface NewsModelService {

    void create(NewsDTO newsDTO);

    List<NewsDTO> readAll();

    NewsDTO read(int id);

    boolean update(NewsDTO news, int id);

    boolean delete(int id);
}
