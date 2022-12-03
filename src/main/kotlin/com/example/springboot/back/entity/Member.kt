package com.example.springboot.back.entity

import javax.persistence.*

@Entity
@Table(name = "member")
class Member(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", length = 255)
    var memberId: Long ?= null,        // 회원 번호

    @Column(name = "member_phone", nullable = false, length = 255)
    var memberPhone: String?,   // 회원 전화번호

    @Column(name = "member_address", nullable = false, length = 255)
    var address: String ?= null,        // 회원 주소

    @Column(name = "member_mileage", nullable = false, length = 255)
    var mileAge: Int ?= 0               // 회원 사용량
    ): BaseEntity(){

}


