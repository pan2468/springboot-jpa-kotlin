package com.example.springboot.client.controller

import com.example.springboot.back.entity.Member
import com.example.springboot.back.repository.MemberRepository
import com.example.springboot.back.service.MemberDaoService
import com.example.springboot.client.dto.MemberDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@TestPropertySource(locations = ["classpath:application.properties"])
@AutoConfigureMockMvc
internal class MemberControllerTest @Autowired constructor(
    internal var memberRepository: MemberRepository,
    internal var memberDaoService: MemberDaoService
){


    @Test
    fun memberJoin(){

        //given
        val memberRequest = MemberDto.MemberRequest(member_id = 1L, member_phone = "010-1111-2222", address = "경기도 부천시 원미구 도당동", mileage = 2)

        //when
        val member = Member(
            memberId = memberRequest.member_id,
            memberPhone = memberRequest.member_phone,
            address = memberRequest.address,
            mileAge = memberRequest.mileage
        )

        val memberSaveToString = memberRepository.save(member)

        //then
        assertEquals(memberSaveToString.memberId,1L)
        assertEquals(memberSaveToString.memberPhone,"010-1111-2222")
        assertEquals(memberSaveToString.address,"경기도 부천시 원미구 도당동")
        assertEquals(memberSaveToString.mileAge,2)
    }

    @Test
    fun `회원 목록 DB 조회`(){
        this.memberJoin()

        val memberListAll: List<Member> = memberRepository.findAll()

        assertEquals(memberListAll.get(0).memberId, 1L)
        assertEquals(memberListAll.get(0).memberPhone,"010-1111-2222")
    }

    @Test
    @Transactional
    fun `회원 중복 예외` (){

        //given
        var member = Member(
            memberId = 1L,
            memberPhone = "010-0000-0000",
            address = "경기도 부천시 원미구",
            mileAge = 2
        )

        var member1 = member
        member1.memberPhone = "010-0000-0000"

        memberRepository.save(member) // 회원 가입 등록

        //when
        val e: Throwable = assertThrows(IllegalStateException::class.java) { memberDaoService.memberJoin(member1) }

        //then
        assertEquals("이미 가입된 회원입니다.", e.message)
    }
    
}

