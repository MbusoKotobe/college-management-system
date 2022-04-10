package za.ac.cput.repository;

import za.ac.cput.entity.StudentDepartment;
import za.ac.cput.factory.StudentDepartmentFactory;

import java.util.HashSet;
import java.util.Set;

public class StudentDepartmentRepository implements IStudentDepartment {


    private static StudentDepartmentRepository repository = null;
    private Set<StudentDepartment> studentDB = null;
    private StudentDepartment Student;

    private StudentDepartmentRepository() {
        this.studentDB = new HashSet<>();

        public static StudentDepartmentRepository getRepository () {
            if (repository == null) {
                repository = new StudentDepartmentRepository();
            }
            return repository;
        }
        public static StudentDepartment createStudent (long studentNumber, int departmentId){
            // return null;
            return studentDepartment;
        }
        @Override
        public StudentDepartment create ( long studentDepartment){
            for (StudentDepartment studen : studentDB) {
                if ( studen.getStudentNumber().equals(studen);
                return;
            }
        }


    }

    @Override
    public StudentDepartment read(String studentNumber) {
        for (StudentDepartment student : studentDB) {
            if (student.getStudentNumber().equals(student)) {

            }
        }


    }

    @Override
    public StudentDepartment update(StudentDepartment studentDepartment) {
        StudentDepartment oldStudent = read(StudentDepartment student);
        if (oldStudent != null) {
            studentDB.remove(oldStudent);
            studentDB.add(studentDepartment);
            return studentDepartment;
        }
        return null;

    }

    @Override
    public boolean delete(String studentNumber) {
        StudentDepartment studentToDelete = read(studentNumber);
        if (studentToDelete == null)
            return false;
        studentDB.remove(studentToDelete);
        return true;
    }

    @Override
    public Set<StudentDepartment> getAll() {
        return studentDB;
    }
}
