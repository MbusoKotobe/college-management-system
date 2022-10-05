/* CourseFactory.java
Factory for the Course Entity
Author: Jody Kearns (209023651)
Date: 06 April 2022 */

package za.ac.cput.factory;

import za.ac.cput.entity.Course;

public class CourseFactory {
    public static Course createCourse(int courseId, String courseName, String courseDescription){
        Course course = new Course.Builder().setCourseId(courseId)
                .setCourseName(courseName)
                .setCourseDescription(courseDescription)
                .build();
        return course;
    }
}
