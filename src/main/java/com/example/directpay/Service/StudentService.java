package com.example.directpay.Service;

import com.example.directpay.Entity.Student;
import com.example.directpay.Repo.StudentRepo;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentService {

    private final RestTemplate restTemplate;
    private final StudentRepo studentRepo;

    public StudentService( StudentRepo studentRepo) {
        this.restTemplate = new RestTemplate();
        this.studentRepo = studentRepo;
    }

    public Student addDetails(Student student){

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
