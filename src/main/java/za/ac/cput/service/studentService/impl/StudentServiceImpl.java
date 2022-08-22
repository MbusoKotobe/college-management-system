package za.ac.cput.service.studentService.impl;

/*
author: Ameer Ismail
student nr: 218216033
Service impl: StudentServiceImpl
ADP 3 Assignment Group1
Service implementation
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Student;
import za.ac.cput.repository.IStudentRepository;
import za.ac.cput.service.studentService.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService
{
    private final IStudentRepository repo;

    @Autowired
    public StudentServiceImpl(IStudentRepository repo) {
        this.repo = repo;
    }

    // creating a student
    @Override
    public Student save(Student student)
    {
        return this.repo.save(student);
    }

    // reading a student
    @Override
    public Optional<Student> read(Long id)
    {
        return this.repo.findById(String.valueOf(id));
    }

    //deleting a student
    @Override
    public void delete(Student student)
    {
        this.repo.delete(student);
    }

    //get all students
    @Override
    public List<Student> findAll() {
        return this.repo.findAll();
    }

    @Override
    public void deleteById(Long id)
    {
        repo.deleteById(String.valueOf(id));
        Optional<Student> student = read(Long.valueOf(id));
        if (student.isPresent())
        {
            delete(student.get());
        }

    }
}
