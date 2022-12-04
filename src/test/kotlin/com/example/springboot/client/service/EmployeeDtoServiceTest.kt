package com.example.springboot.client.service

import com.example.springboot.back.entity.Employee
import com.example.springboot.back.repository.EmployeeRepository
import com.example.springboot.client.dto.EmployeeDto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.transaction.annotation.Transactional


@TestPropertySource(locations = ["classpath:application.properties"])
@SpringBootTest
internal class EmployeeDtoServiceTest @Autowired constructor(
    val employeeRepository: EmployeeRepository
){

    @Test
    @Transactional
    @DisplayName("저장 API 조회")
    fun employeeSave (){
        //given
        val employeeRequest = EmployeeDto.EmployeeRequest(
            employeeId = 1L,
            employeeAddress = "경기도 부천시 원미구",
            employeeName = "홍길동",
            employeePhone = "010-0000-0000",
            employeePassword = "2468"
        )
        val employee = Employee(
            employeeId = employeeRequest.employeeId,
            employeeName = employeeRequest.employeeName,
            employeeAddress = employeeRequest.employeeAddress,
            employeePhone = employeeRequest.employeePhone,
            employeePassword = employeeRequest.employeePassword
        )

        //when
        val employeeList = employeeRepository.save(employee)

        //then
        println(employeeList.toString())
    }
}