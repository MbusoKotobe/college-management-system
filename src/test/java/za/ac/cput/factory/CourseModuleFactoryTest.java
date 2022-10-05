/* CourseModuleFactoryTest.java
Test for CourseModuleFactory
Author: Jody Kearns (209023651)
Date: 09 April 2022 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.CourseModule;

import static org.junit.jupiter.api.Assertions.*;

class CourseModuleFactoryTest {

    @Test
    void createCourseModule() {
        CourseModule courseModule = CourseModuleFactory.createCourseModule(1, "ADP362S");
        assertNotNull(courseModule);
        System.out.println(courseModule);
    }
}