package za.ac.cput.factory;

import za.ac.cput.entity.StudentDepartment;



public class StudentDepartmentFactory {
    public static StudentDepartment createStudentDepartment(long studentNumber, int departmentId){
       StudentDepartment studentDepartment = new StudentDepartment.Builder().setStudentNumber(studentNumber)
                .setDepartmentId(departmentId)
                .build();
        return studentDepartment;

    }
}
