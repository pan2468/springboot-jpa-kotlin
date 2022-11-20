package com.example.springboot.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "retal")
class Retal(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "retal_id", length = 255)
    var retal_id: Long ?= null, //예약 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private var book: Book? = null, // 도서

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private var member: Member? = null, //회원

    @Column(name = "retal_fee", length = 255)
    var retal_fee: Int ?=0,

    @Column(name = "retal_period", length = 255)
    var retal_period: LocalDateTime,

    @Column(name = "late_fee", length = 255)
    var late_fee: Int ?= 0

    ): BaseEntity(){

}