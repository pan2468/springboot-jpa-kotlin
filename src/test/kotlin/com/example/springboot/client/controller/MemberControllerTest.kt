package com.example.springboot.client.controller

import com.example.springboot.back.entity.Member
import com.example.springboot.back.repository.MemberRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureMockMvc
internal class MemberControllerTest @Autowired constructor(
    internal var memberRepository: MemberRepository
){

    @Test
    fun `회원 가입 DB 저장` (){
        //given
        val member = Member()
        //when

        //then

    }


}

