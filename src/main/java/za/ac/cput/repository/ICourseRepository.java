/* ICourseRepository.java
Interface for the CourseRepositoryImpl
Author: Jody Kearns (209023651)
Date: 07 April 2022 */

package za.ac.cput.repository;

import za.ac.cput.repository.entity.Course;
import java.util.Set;

public interface ICourseRepository extends IRepository<Course, Integer>{
    Set<Course> getAll();
}
