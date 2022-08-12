package za.ac.cput.repository;


/*
author: Ameer Ismail
student nr: 218216033
Repository: StudentRepositoryImpl
ADP 3 Assignment Group1
*/

import za.ac.cput.repository.entity.Student;

import java.util.Set;

public class StudentRepositoryImpl implements IStudentRepository
{
    //implementing the repository and DB
    private static StudentRepositoryImpl repository = null;
    private Set<Student> StudentDB = null;

    private StudentRepositoryImpl getRepository()
    {
        if (repository == null)
        {
            repository = new StudentRepositoryImpl();
        }
        return repository;
    }

    // CRUD methods
    // -- create
    @Override
    public Student create(Student student)
    {
        boolean success = StudentDB.add(student);
        if (!success)
            return null;

        return student;
    }

    // read
    @Override
    public Student read(String firstName)
    {
        Student student = StudentDB.stream()
                .filter(s -> s.getFirstName().equals(firstName))
                .findAny()
                .orElse(null);
        return student;
    }

    // update
    @Override
    public Student update(Student s)
    {
        Student previousStudent = read(s.getFirstName());
        if (previousStudent != null)
        {
            StudentDB.remove(previousStudent);
            StudentDB.add(s);
            return s;
        }
        return null;
    }

    //delete
    @Override
    public boolean delete(String firstName)
    {
        Student deleteStudent = read(firstName);
        if(firstName == null)
            return false;

        StudentDB.remove(deleteStudent);
        return true;
    }

    // get all
    @Override
    public Set<Student> getAll()
    {
        return StudentDB;
    }
}