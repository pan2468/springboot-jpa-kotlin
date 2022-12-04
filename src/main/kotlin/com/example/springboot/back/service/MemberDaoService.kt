package com.example.springboot.back.service

import com.example.springboot.back.entity.Member
import com.example.springboot.back.repository.MemberRepository
import com.example.springboot.client.dto.MemberDto
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class MemberDaoService (
    val memberRepository: MemberRepository
    ){

    fun memberJoin(member: Member){

        validateDuplicateMember(member);
        memberRepository.save(member)
    }

    private fun validateDuplicateMember(member: Member) {
        val findMember: Member? = member.memberPhone?.let {
            memberRepository.findByMemberPhone(it)
        }
        if(findMember != null) {
            throw IllegalStateException("이미 가입된 회원입니다.")
        }
    }

    fun memberSave(
        memberRequest: MemberDto.MemberRequest
    ){
        val memberSave = Member(
            memberPhone = memberRequest.member_phone,
            address = memberRequest.address,
            mileAge = memberRequest.mileage
        ).let {
            memberRepository.save(it)
        }
    }
}

