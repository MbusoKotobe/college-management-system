/***
 * Department.java
 * Entity for the Department
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 06 April 2022
 */
package za.ac.cput.repository;

import za.ac.cput.entity.StudentDepartment;

import java.util.HashSet;
import java.util.Set;

public class StudentDepartmentRepository implements IStudentDepartment {

    private static StudentDepartmentRepository repository;
    Set<StudentDepartment> studentDepartment;

    public StudentDepartmentRepository() {


        studentDepartment = new HashSet<StudentDepartment>();

    }

    public static StudentDepartmentRepository getIStudentRepository() {
        if (repository == null) repository = new StudentDepartmentRepository();

        return repository;


    }

    @Override
    public StudentDepartment create(StudentDepartment students) {
        if (students != null) studentDepartment.add(students);
        return students;

    }

    @Override
    public StudentDepartment read(Long studentNumber) {
        return studentDepartment.stream()
                .filter(department -> department.getStudentNumber() == studentNumber)
                .findAny().orElse(null);

    }
        @Override
        public StudentDepartment update (StudentDepartment studentNumber){

        StudentDepartment oldStudent = read(studentNumber.getStudentNumber());
        if (oldStudent != null) {
            studentDepartment.remove(oldStudent);
            studentDepartment.add(studentNumber);
            return studentNumber;
        }
        return null;

    }

    @Override
    public boolean delete(Long studentNumber) {
        StudentDepartment studentToDelete = read(studentNumber);
        if (studentToDelete == null)
            return false;
        else studentDepartment.remove(studentNumber);
        return true;
    }

    @Override
    public Set<StudentDepartment> getAll() {
        return studentDepartment;
    }
}
