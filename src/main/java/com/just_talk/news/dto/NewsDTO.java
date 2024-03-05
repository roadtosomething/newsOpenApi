package com.just_talk.news.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsDTO {
    private int id;
    private String title;
    private String description;
    private AuthorsDTO author;
    private LocalDateTime date;
}
