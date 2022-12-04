package com.example.springboot.client.dto


import io.swagger.annotations.ApiModelProperty


object MemberDto {

    data class MemberRequest(

        @ApiModelProperty(name = "회원 전화번호", example = "010-1111-2222", required = true)
        var member_phone: String ?= null,   // 회원 전화번호

        @ApiModelProperty(name = "회원 주소", example = "경기도 부천시 원미구", required = true)
        var address: String ?= null,        // 회원 주소

        @ApiModelProperty(name = "회원 사용량", example = "2", required = true)
        var mileage: Int ?= 0               // 회원 사용량

    )

}