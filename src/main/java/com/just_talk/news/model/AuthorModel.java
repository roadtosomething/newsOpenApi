package com.just_talk.news.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "authors")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AuthorModel {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authors_gen")
    @SequenceGenerator(name = "authors_gen", sequenceName = "authors_id_seq", allocationSize = 1, initialValue = 2)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="org_name")
    private String orgName;
}
