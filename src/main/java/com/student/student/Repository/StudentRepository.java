package com.student.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.student.Model.StudentModel;

import java.util.Optional;

public interface StudentRepository extends JpaRepository <StudentModel,Integer> {
  
    Optional<StudentModel> findByNameAndPassword(String name,String password);

    Optional<StudentModel> findFirstByName(String name);

}

