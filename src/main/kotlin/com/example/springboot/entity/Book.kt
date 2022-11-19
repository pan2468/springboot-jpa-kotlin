package com.example.springboot.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "book")
class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", length = 255)
    var book_id: Long ?= null, //도서 번호

    @Column(name = "book_name", nullable = false, length = 255)
    var book_name: String ?= null, // 도서 이름

    @Column(name = "book_pubilsher", nullable = false, length = 255)
    var pubilsher: String ?= null, // 발행자

    @Column(name = "book_auther", nullable = false, length = 255)
    var auther: String ?= null,

    @Column(name = "book_genre", nullable = false, length = 255)
    var genre: String ?= null,

    @Column(name = "book_price", length = 255)
    var price: Int,

    @Column(name = "reg_date", length = 255)
    var reg_date: LocalDateTime

)