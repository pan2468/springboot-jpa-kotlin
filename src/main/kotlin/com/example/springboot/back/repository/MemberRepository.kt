package com.example.springboot.back.repository

import com.example.springboot.back.entity.Member
import com.example.springboot.back.entity.MemberMd
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long>{

     fun findByMemberId(memberId: Long?): Member

     fun findByMemberPhone(memberPhone: String): Member

}