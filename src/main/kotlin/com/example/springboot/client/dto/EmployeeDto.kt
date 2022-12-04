package com.example.springboot.client.dto

import com.example.springboot.back.entity.Employee
import io.swagger.annotations.ApiModelProperty

object EmployeeDto{

    data class EmployeeRequest(
        @ApiModelProperty(name = "종업원 번호", required = true)
        var employeeId: Long ?= null,

        @ApiModelProperty(name = "종업원 명", example = "홍길동", required = true)
        var employeeName: String ?= null,

        @ApiModelProperty(name = "종업원 주소", example = "경기도 부천시 원미구", required = true)
        var employeeAddress: String ?= null,        // 회원 주소

        @ApiModelProperty(name = "전화번호", example = "2", required = true)
        var employeePhone: String ?= null,               // 회원 사용량

        @ApiModelProperty(name = "종업원 비밀번호", example = "2468", required = true)
        var employeePassword: String ?= null
    )

    data class EmployeeResponse(
        var employeeId: Long?
    ) {

        companion object{

            fun employeeList(entity: Employee){
                val employeeId = entity.employeeId
            }
        }
    }


}