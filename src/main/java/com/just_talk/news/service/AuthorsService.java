package com.just_talk.news.service;

import com.just_talk.news.dto.AuthorsDTO;
import com.just_talk.news.dto.NewsDTO;

import java.util.List;

public interface AuthorsService {
    void create(AuthorsDTO newsDTO);

    List<AuthorsDTO> readAll();

    AuthorsDTO read(int id);

    boolean update(AuthorsDTO authors, int id);

    boolean delete(int id);
}
