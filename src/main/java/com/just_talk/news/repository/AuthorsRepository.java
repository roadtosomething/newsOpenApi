package com.just_talk.news.repository;

import com.just_talk.news.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface AuthorsRepository extends JpaRepository<AuthorModel, Integer> {
    List<AuthorModel> findAuthorModelByNameAndOrgName (String name, String orgName);
}
