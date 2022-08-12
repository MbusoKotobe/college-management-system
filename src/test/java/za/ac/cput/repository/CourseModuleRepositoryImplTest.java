/* CourseModuleRepositoryImplTest.java
Test for CourseModuleRepositoryImpl
Author: Jody Kearns (209023651)
Date: 09 April 2022 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.repository.entity.CourseModule;
import za.ac.cput.factory.CourseModuleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CourseModuleRepositoryImplTest {
    private static CourseModuleRepositoryImpl courseModuleRepo = CourseModuleRepositoryImpl.getCourseModuleRepository();
    private static CourseModule courseModule1 = CourseModuleFactory.createCourseModule(25, "ITS362S");

    @Test
    void a_create() {
        CourseModule courseModuleCreated = courseModuleRepo.create(courseModule1);
        assertEquals(courseModule1.getCourseId(), courseModuleCreated.getCourseId());
        System.out.println("Created: " + courseModuleCreated);
    }

    @Test
    void b_read() {
        CourseModule read = courseModuleRepo.read(courseModule1.getCourseId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        CourseModule updated = new CourseModule.Builder().copy(courseModule1).setModuleId("PRM262S")
                .build();
        assertNotNull(courseModuleRepo.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean outcome = courseModuleRepo.delete(courseModule1.getCourseId());
        assertTrue(outcome);
        System.out.println("Deleted: " + outcome);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: ");
        System.out.println(courseModuleRepo.getAll());
    }
}