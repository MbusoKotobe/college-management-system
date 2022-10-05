/* ICourseRepository.java
Interface for the CourseRepositoryImpl
Author: Jody Kearns (209023651)
Date: 07 April 2022 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Course;

public interface ICourseRepository extends JpaRepository<Course, String> {
}
