/***
 * Department.java
 * Entity for the Department
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 06 April 2022
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.StudentDepartment;
import za.ac.cput.factory.StudentDepartmentFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudentDepartmentRepositoryTest {
    private static StudentDepartmentRepository repository = StudentDepartmentRepository.getIStudentRepository();
    private static StudentDepartment student = StudentDepartmentFactory.createStudentDepartment(213063964, 1);

    @Test
    void a_create() {
        StudentDepartment created = repository.create(student);
        assertEquals(student.getStudentNumber(), created.getStudentNumber());
        System.out.println("Created" + created);
    }

    @Test
    void b_read() {
        StudentDepartment read = repository.read(student.getStudentNumber());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_update() {
       StudentDepartment updated = new StudentDepartment().Builder().copy(student).setFirstName("Elvis")
                .setLastName("Ndlangamandla")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated " + updated);

    }

    @Test
    void e_delete() {
        boolean success = repository.delete(student.getStudentNumber());
        assertTrue(success);
        System.out.println("Deleted " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all");
        System.out.println(repository.getAll());
    }

}