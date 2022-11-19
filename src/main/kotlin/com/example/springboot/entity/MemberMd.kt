package com.example.springboot.entity

import javax.persistence.*

@Entity
@Table(name = "member_md")
class MemberMd(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reg_id", length = 255)
    var reg_id: Long ?= null,   // 등록 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private var retal: Retal? = null, // 예약

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private var member: Member? = null, // 회원
)