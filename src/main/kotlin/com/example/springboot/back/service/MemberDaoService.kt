package com.example.springboot.back.service

import com.example.springboot.back.entity.Member
import com.example.springboot.back.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberDaoService (
    internal var memberRepository: MemberRepository
    ){

    fun memberJoin(member: Member): Member {

        validateDuplicateMember(member);
        return memberRepository.save(member)

    }

    private fun validateDuplicateMember(member: Member) {
        val findMember: Member = memberRepository.findByMemberPhone(member.memberPhone)
        if(findMember != null) {
            throw IllegalStateException("이미 가입된 회원입니다.")
        }
    }

}