package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.entity.LecturerDepartment;
import za.ac.cput.factory.LecturerDepartmentFactory;
import za.ac.cput.factory.LecturerFactory;

import static org.junit.jupiter.api.Assertions.*;

class LecturerDepartmentRepositoryTest {
    private static LecturerDepartmentRepository repository =
            LecturerDepartmentRepository.createLectureDepartmentRepository();
    private static LecturerDepartment lecturerDepartment =
            LecturerDepartmentFactory.createLecturerDepartment(12359645, 45698788);

    @Test
    void create() {
        LecturerDepartment created = repository.create(lecturerDepartment);
        assertEquals(lecturerDepartment.getLectureId(), created.getLectureId());
        assertEquals(lecturerDepartment.getDepartmentId(), created.getDepartmentId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        LecturerDepartment read = repository.read(lecturerDepartment.getLectureId()
                , lecturerDepartment.getDepartmentId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void delete() {
        boolean success = repository.delete(lecturerDepartment.getLectureId()
                , lecturerDepartment.getDepartmentId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }

}