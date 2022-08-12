package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.repository.entity.StudentCourse;
import za.ac.cput.factory.StudentCourseFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class StudentCourseRepositoryImplTest
{

    private static StudentCourseRepositoryImpl repository = StudentCourseRepositoryImpl.getRepo();
    private static StudentCourse studentCourse = StudentCourseFactory.createStudentCourse(364);

    //test 1 create
    @Test
    void a_create()
    {
        StudentCourse create = repository.create(studentCourse);
        assertEquals(studentCourse.getCourseId(), create.getCourseId());
        System.out.println("Create: " + create);
    }

    //test 2 read
    @Test
    void b_read()
    {
        StudentCourse read = repository.read(studentCourse.getCourseId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    //test 3 update
    @Test
    void c_update()
    {
        StudentCourse update = new StudentCourse.Builder()
                .copy(studentCourse)
                .setStudentNumber(studentCourse.getStudentNumber())
                .setCourseId(studentCourse.getCourseId())
                .build();
        assertNotNull(repository.update(update));
        System.out.println("Update: " + update);
    }

    //test 5 delete
    @Test
    void e_delete()
    {
        boolean success = repository.delete(studentCourse.getCourseId());
        assertTrue(success);
        System.out.println("Delete: " + true );
    }

    //test 4 get all
    @Test
    void d_getAll()
    {
        System.out.println("Show: ");
        System.out.println(repository.getAll());
    }
}