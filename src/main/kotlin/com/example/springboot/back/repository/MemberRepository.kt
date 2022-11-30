package com.example.springboot.back.repository

import com.example.springboot.back.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>{

}