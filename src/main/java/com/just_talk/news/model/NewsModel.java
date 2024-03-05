package com.just_talk.news.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Table(name = "news")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NewsModel {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_gen")
    @SequenceGenerator(name = "news_gen", sequenceName = "news_id_seq", allocationSize = 1, initialValue = 8)
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "author")
    private AuthorModel author;

    @Column(name="date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
}
