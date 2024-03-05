package com.just_talk.news.service;

import com.just_talk.news.dto.AuthorsDTO;
import com.just_talk.news.repository.AuthorsRepository;

import java.util.List;

public class AuthorsServiceImpl implements AuthorsService{

    private final AuthorsRepository authorsRepository;

    AuthorsServiceImpl(AuthorsRepository authorsRepository) {this.authorsRepository = authorsRepository;}

    @Override
    public void create(AuthorsDTO newsDTO) {

    }

    @Override
    public List<AuthorsDTO> readAll() {
        return null;
    }

    @Override
    public AuthorsDTO read(int id) {
        return null;
    }

    @Override
    public boolean update(AuthorsDTO authors, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
