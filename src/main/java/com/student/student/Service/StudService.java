package com.student.student.Service;


import java.util.List;

import com.student.student.Model.StudentModel;



public interface StudService {
    
    List<StudentModel>getAllStudent();
    
    void saveStudent(StudentModel studentModel);

    StudentModel getStudentById(Integer id);

    void deleteStudentById(Integer id);
}