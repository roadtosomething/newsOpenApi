package com.just_talk.news.service;

import com.just_talk.news.model.NewsModel;

import java.util.*;

public interface NewsModelService {

    void create(NewsModel newsModel);

    List<NewsModel> readAll();

    NewsModel read(int id);

    boolean update(NewsModel client, int id);

    boolean delete(int id);
}
