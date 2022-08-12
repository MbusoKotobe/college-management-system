package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.repository.entity.LecturerDepartment;
import za.ac.cput.factory.LecturerDepartmentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class LecturerDepartmentRepositoryImplTest {
    private static LecturerDepartmentRepositoryImpl repository =
            LecturerDepartmentRepositoryImpl.createLectureDepartmentRepository();
    private static LecturerDepartment lecturerDepartment =
            LecturerDepartmentFactory.createLecturerDepartment(12359645, 45698788);

    @Test
    void a_create() {
        LecturerDepartment created = repository.create(lecturerDepartment);
        assertEquals(lecturerDepartment.getLectureId(), created.getLectureId());
        assertEquals(lecturerDepartment.getDepartmentId(), created.getDepartmentId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        LecturerDepartment read = repository.read(lecturerDepartment.getLectureId()
                , lecturerDepartment.getDepartmentId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_delete() {
        boolean success = repository.delete(lecturerDepartment.getLectureId()
                , lecturerDepartment.getDepartmentId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }

}