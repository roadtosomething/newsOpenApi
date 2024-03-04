package com.just_talk.news.service;

import com.just_talk.news.model.NewsModel;
import com.just_talk.news.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class NewsModelServiceImpl implements NewsModelService{
    private final NewsRepository newsRepository;

    public NewsModelServiceImpl (NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }
    @Override
    public void create(NewsModel newsModel) {
        newsRepository.save(newsModel);
    }

    @Override
    public List<NewsModel>  readAll() {
        return newsRepository.findAll();
    }

    @Override
    public NewsModel read(int id) {
        return newsRepository.getOne(id);
    }

    @Override
    public boolean update(NewsModel newsModel, int id) {
        if (newsRepository.existsById(id)) {
            newsModel.setId(id);
            newsRepository.save(newsModel);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (newsRepository.existsById(id)) {
            newsRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
