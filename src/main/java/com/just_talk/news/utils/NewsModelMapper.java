package com.just_talk.news.utils;

import com.just_talk.news.dto.AuthorsDTO;
import com.just_talk.news.dto.NewsDTO;
import com.just_talk.news.model.AuthorModel;
import com.just_talk.news.model.NewsModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsModelMapper {

    public NewsDTO mapToDto(NewsModel newsModel){
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(newsModel.getId());
        newsDTO.setTitle(newsModel.getTitle());
        newsDTO.setDescription(newsModel.getDescription());

        AuthorsDTO authorsDTO = new AuthorsDTO();
        authorsDTO.setId(newsModel.getAuthor().getId());
        authorsDTO.setName(newsModel.getAuthor().getName());
        authorsDTO.setOrgName(newsModel.getAuthor().getOrgName());

        newsDTO.setAuthor(authorsDTO);
        newsDTO.setDate(newsModel.getDate());

        return newsDTO;
    }

    public List<NewsDTO> mapToDto(List<NewsModel> newsModels){
        return newsModels.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public NewsModel mapToEntity (NewsDTO newsDTO){
        NewsModel newsModel = new NewsModel();
        newsModel.setTitle(newsDTO.getTitle());
        newsModel.setDescription(newsDTO.getDescription());
        newsModel.setDate(newsDTO.getDate());

        AuthorModel authorModel = new AuthorModel();
        authorModel.setId(newsDTO.getAuthor().getId());
        authorModel.setName(newsDTO.getAuthor().getName());
        authorModel.setOrgName(newsDTO.getAuthor().getOrgName());

        newsModel.setAuthor(authorModel);
        return newsModel;
    }

}
