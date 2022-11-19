package com.example.springboot.entity

import javax.persistence.*

@Entity
@Table(name ="employee")
class Employee(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    var employee_id: Long ?= null,          // 사원 번호

    @Column(name = "employee_name", nullable = false, length = 255)
    var employee_name: String ?= null,      // 사원 이름

    @Column(name = "employee_address", nullable = false, length = 255)
    var employee_address: String ?= null,   // 사원 주소

    @Column(name = "employee_phone", nullable = false, length = 255)
    var employee_phone: String ?= null,     // 사원 전화번호

    @Column(name = "employee_password", nullable = false, length = 255)
    var employee_password: String ?= null   // 사원 비밀번호

){

}
