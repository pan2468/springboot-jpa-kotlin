package com.example.springboot.entity

import javax.persistence.*

@Entity
@Table(name = "library_md")
class LibraryMd(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "library_md", length = 255)
    var library_md: Long ?= null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private var book: Book? = null, // 도서

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private var employee: Employee? = null, // 사원

    @Column(name = "library_location", length = 300)
    var location: String,

    @Column(name = "retal_yn", length = 255)
    var retal_yn: String
)