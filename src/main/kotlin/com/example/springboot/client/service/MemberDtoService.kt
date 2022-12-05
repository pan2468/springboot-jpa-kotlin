package com.example.springboot.client.service

import com.example.springboot.back.service.MemberDaoService
import com.example.springboot.client.dto.MemberDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberDtoService @Autowired constructor(
    val memberDaoService: MemberDaoService
){

    @Transactional
    fun memberJoin(
        memberRequest: MemberDto.MemberRequest
    ){
        memberDaoService.memberSave(memberRequest)
    }

    @Transactional(readOnly = true)
    fun memberList(): MemberDto.MemberListRespose {

        val memberList =  memberDaoService.getMemberList()

       val memberListAll =  MemberDto.MemberListRespose(
            memberId = memberList.get(0).memberId,
            member_phone = memberList.get(0).memberPhone,
            address = memberList.get(0).address,
            mileage = memberList.get(0).mileAge
        )

        return memberListAll
    }


}