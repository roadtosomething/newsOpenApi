package com.just_talk.news.controller;

import com.just_talk.news.model.NewsModel;
import com.just_talk.news.service.NewsModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("news")
public class NewsModelController {

    private final NewsModelService newsModelService;

    @Autowired
    public NewsModelController(NewsModelService newsModelService) {
        this.newsModelService = newsModelService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody NewsModel newsModel){
        newsModelService.create(newsModel);
        return new ResponseEntity<>(newsModel, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<NewsModel> read(@PathVariable int id){
        final NewsModel news = newsModelService.read(id);

        return news!= null
                ?new ResponseEntity<>(news, HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<List<NewsModel>> read(){
        final List<NewsModel> news = newsModelService.readAll();

        return news!=null && !news.isEmpty()
                ?new ResponseEntity<>(news, HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody NewsModel newsRequest){
        final boolean updated = newsModelService.update(newsRequest,id);

        return updated
                ?new ResponseEntity<>(HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name= "id") int id){
        final boolean deleted = newsModelService.delete(id);

        return deleted
                ?new ResponseEntity<>(HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}



