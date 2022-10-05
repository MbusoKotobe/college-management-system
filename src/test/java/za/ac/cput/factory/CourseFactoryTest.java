/* CourseFactoryTest.java
Test for CourseFactory
Author: Jody Kearns (209023651)
Date: 09 April 2022 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Course;
import za.ac.cput.entity.Module;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CourseFactoryTest {

    @Test
    void createCourse() {
        Set<Module> modules = new HashSet<>();
        Course course = CourseFactory.createCourse("23","ICT:Diploma in Applications Development",
                "3 year Diploma course in applications and software development", modules);
        assertNotNull(course);
        System.out.println(course);
    }
}