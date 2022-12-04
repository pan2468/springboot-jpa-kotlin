package com.example.springboot.client.controller

import com.example.springboot.back.entity.Member
import com.example.springboot.client.dto.MemberDto
import com.example.springboot.client.service.MemberDtoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController @Autowired constructor(
    val memberDtoService: MemberDtoService
){

    @PostMapping("/member/join")
    fun memberJoin(
        @RequestBody memberRequest: MemberDto.MemberRequest
    ){
         memberDtoService.memberJoin(memberRequest)
    }


}

