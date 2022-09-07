package com.student.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.student.Model.StudentModel;


@Repository
public interface StudRepository extends JpaRepository<StudentModel,Integer>{
    
}