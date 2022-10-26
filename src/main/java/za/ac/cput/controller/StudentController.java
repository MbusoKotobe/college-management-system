package za.ac.cput.controller;

/*
author: Ameer Ismail
student nr: 218216033
Controller impl: Student Controller
ADP 3 Assignment Group1
Student Domain Controller
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("college-management-system/student/")
@Slf4j
public class StudentController
{
    private final IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService)
    {
        this.studentService = studentService;
    }

    //Saving or creating
    @PostMapping("save")
    public ResponseEntity<Student> save (@RequestBody Student student)
    {
        log.info("Save Request: ", student);

        Student ValidateStudent;
        try
        {
            ValidateStudent = StudentFactory.createStudent(student.getFirstName(), student.getMiddleName(),
                    student.getLastName(), student.getStudentNumber());
        }catch (IllegalArgumentException i)
        {
            log.info("Save error: ", i.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Student save = studentService.save(ValidateStudent);
        return ResponseEntity.ok(save);

    }

    //reading
    @GetMapping("read/{id}")
    public ResponseEntity<Student> read(@PathVariable Long id)
    {
        log.info("Read Request: ", id);
        Student student = this.studentService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }

    //find all
    @GetMapping("find-all")
    public ResponseEntity<List<Student>> findAll()
    {
        List<Student> studentLists = this.studentService.findAll();
        return ResponseEntity.ok(studentLists);
    }

    //deleting
    @DeleteMapping("delete/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id)
    {
        log.info("Delete Req: ", id);
        this.studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
