package com.example.springboot.back.repository

import com.example.springboot.back.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository: JpaRepository<Employee, Long>{

    @Query("""
            SELECT m 
            FROM Employee e INNER JOIN Member m
            ON e.employeeId = m.memberId 
            WHERE e.employeeId =: employeeId
         """)
    fun findByEmployeeId(employeeId: Long?): Employee




}