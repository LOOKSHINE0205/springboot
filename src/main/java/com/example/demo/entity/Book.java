package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity // JPA API -> create table book
// JPA API(엔진 : Hibernate)|
// Object -> Table Mapping : ORM -> SQL 생성


public class Book {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동증가
    private Long id;

   @Column(name = "title", unique = true, nullable = false, length = 40) // length 기본255 varchar
    private String title; // 개별마다 컬럼제약조건을 걸어야합니다.

    private int price;

    private String author;

    private int page;
}
//Book, BookDTO 두개를 만듭니다.
