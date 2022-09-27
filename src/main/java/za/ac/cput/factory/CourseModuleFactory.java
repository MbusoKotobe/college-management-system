/* CourseModuleFactory.java
Factory for the CourseModule Entity
Author: Jody Kearns (209023651)
Date: 06 April 2022 */

package za.ac.cput.factory;

import za.ac.cput.repository.entity.CourseModule;

public class CourseModuleFactory {
    public static CourseModule createCourseModule(int courseId, String moduleId){
        CourseModule courseModule = new CourseModule.Builder().setCourseId(courseId)
                .setModuleId(moduleId)
                .build();
        return courseModule;
    }
}