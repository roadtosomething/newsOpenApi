package com.just_talk.news.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "news")
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name="author")
    private int author;
    @Column(name="date")
    private Timestamp date;
}
