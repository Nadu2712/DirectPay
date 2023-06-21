package com.example.directpay.Controller;

import com.example.directpay.Entity.Student;
import com.example.directpay.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public Student postDetails(@RequestBody Student student){

        return studentService.addDetails(student);
    }


    @GetMapping("/showStudent")
    public List<Student> getDetails(){

        return studentService.getAllDetails();
    }

    /*@GetMapping("/getStudent/{id}")
    public Student fetchDetailsById(@PathVariable int id){

        return studentService.getStudentById(id);
    }*/

    @GetMapping("/getStudent/{id}")
    public Student fetchDetailsById(@PathVariable int id){

        return studentService.getStudentById(id);
    }

    @PutMapping("/updateStudent")
    public Student updateStudentDetails(@RequestBody Student student){

        return studentService.updateDetails(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {

        return  studentService.deleteStudent(id);
    }
}
