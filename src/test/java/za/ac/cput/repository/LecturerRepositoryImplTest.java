package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.factory.LecturerFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class LecturerRepositoryImplTest {
<<<<<<< HEAD
    private static LecturerRepositoryImpl repository = LecturerRepositoryImpl.createLectureRepository();
    private static Lecturer lecturer = LecturerFactory.createLecturer(1, "Arinze", "Anikwue");
=======
    private static final LecturerRepositoryImpl repository = LecturerRepositoryImpl.createLectureRepository();
    private static final Lecturer lecturer = LecturerFactory.createLecturer("Arinze", "Anikwue");
>>>>>>> cc76966ecbbc0f8c68525a302105f231ee648e71

    @Test
    void a_create() {
        Lecturer created = repository.create(lecturer);
        assertEquals(lecturer.getLecturerId(), created.getLecturerId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Lecturer read = repository.read(lecturer.getLecturerId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Lecturer updated = new Lecturer.Builder().copy(lecturer).setFirstName("Radford")
                .setLastName("Burger")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(lecturer.getLecturerId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }

}