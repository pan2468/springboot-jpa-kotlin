package com.example.springboot.client.controller

import com.example.springboot.back.entity.Member
import com.example.springboot.back.repository.MemberRepository
import com.example.springboot.client.dto.MemberDto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@TestPropertySource(locations = ["classpath:application.properties"])
@AutoConfigureMockMvc
internal class MemberControllerTest @Autowired constructor(
    internal var memberRepository: MemberRepository,
//    internal var mockMvc: MockMvc
){


    @Test
    fun `회원 가입 DB 저장` (){
        //given
        val memberRequest: MemberDto.MemberRequest = MemberDto.MemberRequest(
            member_id = 1L,
            member_phone = "010-1111-2222",
            address = "경기도 부천시 원미구 도당동",
            mileage = 2
        )

        //when
        val member = Member(
            member_id = memberRequest.member_id,
            member_phone = memberRequest.member_phone,
            address = memberRequest.address,
            mileage = memberRequest.mileage
        )

        val memberSaveToString = memberRepository.save(member)

        //then
        Assertions.assertEquals(memberSaveToString.member_id,1L)
        Assertions.assertEquals(memberSaveToString.member_phone,"010-1111-2222")
        Assertions.assertEquals(memberSaveToString.address,"경기도 부천시 원미구 도당동")
        Assertions.assertEquals(memberSaveToString.mileage,2)

    }


}

