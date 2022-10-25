/* CourseFactory.java
Factory for the Course Entity
Author: Jody Kearns (209023651)
Date: 06 April 2022 */

package za.ac.cput.factory;
import za.ac.cput.entity.Course;
import za.ac.cput.utility.Utilities;
import java.util.Iterator;
import java.util.Set;
import za.ac.cput.entity.Module;

public class CourseFactory {
    public static Course createCourse(String courseId, String courseName, String courseDescription, Set<Module> modules){
        Utilities.checkStringParam("courseId", courseId);
        Utilities.checkStringParam("courseName", courseName);
        Utilities.checkStringParam("courseDescription", courseDescription);

        for (Module module : modules) {
            Utilities.checkIfObjectNull("module", module);
        }

        return Course.builder()
                .courseId(courseId)
                .courseName(courseName)
                .courseDescription(courseDescription)
                .modules(modules).build();
    }
}
