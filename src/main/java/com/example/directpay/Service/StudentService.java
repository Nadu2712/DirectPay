package com.example.directpay.Service;

import com.example.directpay.Entity.Student;
import com.example.directpay.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student Details(Student student){
        return studentRepo.save(student);
    }

    public List<Student> getAllDetails() {
        return studentRepo.findAll();
    }

    public Student getStudentById(int id){
        return studentRepo.findById(id).orElseThrow();
    }

    public Student updateDetails(Student student){
        Student updateStudent = studentRepo.findById(student.getId()).orElseThrow(null);
        if(updateStudent!=null)
        {
            updateStudent.setMarks(student.getMarks());
            updateStudent.setName(student.getName());
            studentRepo.save(updateStudent);
        }
        return updateStudent;
    }

    public String deleteStudent(int id){
        studentRepo.deleteById(id);
        return "deleted"+id;
    }
}
