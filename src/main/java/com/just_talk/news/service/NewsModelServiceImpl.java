package com.just_talk.news.service;

import com.just_talk.news.dto.NewsDTO;
import com.just_talk.news.model.NewsModel;
import com.just_talk.news.repository.AuthorsRepository;
import com.just_talk.news.repository.NewsRepository;
import com.just_talk.news.utils.NewsModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class NewsModelServiceImpl implements NewsModelService{
    private final NewsRepository newsRepository;
    private final NewsModelMapper mapper = new NewsModelMapper();

    public NewsModelServiceImpl (NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }
    @Override
    public void create(NewsDTO newsDTO) {
        newsDTO.setId(newsRepository.getNextValueSequence());
        newsRepository.save(mapper.mapToEntity(newsDTO));
    }

    @Override
    public List<NewsDTO> readAll() {
        return mapper.mapToDto(newsRepository.
                findAll().
                stream().
                sorted(Comparator.comparingInt(NewsModel::getId)).
                collect(Collectors.toList()));
    }

    @Override
    public NewsDTO read(int id) {
        return mapper.mapToDto(newsRepository.getOne(id));
    }


    @Override
    public boolean update(NewsDTO newsDTO, int id) {
        if (newsRepository.existsById(id)) {
            newsDTO.setId(id);
            newsRepository.save(mapper.mapToEntity(newsDTO));
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
