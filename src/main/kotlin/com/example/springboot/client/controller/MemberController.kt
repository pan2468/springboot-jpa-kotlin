package com.example.springboot.client.controller

import com.example.springboot.back.entity.Member
import com.example.springboot.client.dto.MemberDto
import com.example.springboot.client.service.MemberDtoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController @Autowired constructor(
    val memberDtoService: MemberDtoService
){

    @PostMapping("/member/join") // 회원 저장 API
    fun memberJoin(
        @RequestBody memberRequest: MemberDto.MemberRequest
    ){
         memberDtoService.memberJoin(memberRequest)
    }

    @GetMapping("/member/list") // 회원 목록 API
    fun memberList(

    ): MemberDto.MemberListRespose{
        val result = memberDtoService.memberList()
        return result
    }




}

