package com.example.springboot.entity

import javax.persistence.*

@Entity
@Table(name = "member")
class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", length = 255)
    var member_id: Long ?= null,        // 회원 번호

    @Column(name = "member_phone", nullable = false, length = 255)
    var member_phone: String ?= null,   // 회원 전화번호

    @Column(name = "member_address", nullable = false, length = 255)
    var address: String ?= null,        // 회원 주소

    @Column(name = "member_mileage", nullable = false, length = 255)
    var mileage: Int ?= 0               // 회원 사용량
    ){

}


