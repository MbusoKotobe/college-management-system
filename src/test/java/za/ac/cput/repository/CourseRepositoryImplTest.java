/* CourseRepositoryImplTest.java
Test for CourseRepositoryImpl
Author: Jody Kearns (209023651)
Date: 09 April 2022 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.repository.entity.Course;
import za.ac.cput.factory.CourseFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CourseRepositoryImplTest {
    private static CourseRepositoryImpl courseRepo = CourseRepositoryImpl.getCourseRepository();
    private static Course course1 = CourseFactory.createCourse(23,"ICT:Diploma AD",
            "3 year Diploma in AD");
    @Test
    void a_create() {
        Course courseCreated = courseRepo.create(course1);
        assertEquals(course1.getCourseId(),courseCreated.getCourseId());
        System.out.println("Created: " + courseCreated);
    }

    @Test
    void b_read() {
        Course read = courseRepo.read(course1.getCourseId());
        assertNotNull(read);
        System.out.println("Read " + read);
    }

    @Test
    void c_update() {
        Course updated = new Course.Builder().copy(course1).setCourseName("ICT: Degree MM")
                .setCourseDescription("This is a multimedia course")
                .build();
        assertNotNull(courseRepo.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean outcome = courseRepo.delete(course1.getCourseId());
        assertTrue(outcome);
        System.out.println("Deleted: " + outcome);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: ");
        System.out.println(courseRepo.getAll());
    }
}