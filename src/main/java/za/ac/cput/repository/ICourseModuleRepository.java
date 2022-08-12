/* ICourseModuleRepository.java
Interface for the CourseModuleRepositoryImpl
Author: Jody Kearns (209023651)
Date: 08 April 2022 */

package za.ac.cput.repository;

import za.ac.cput.repository.entity.CourseModule;
import java.util.Set;

public interface ICourseModuleRepository extends IRepository<CourseModule, Integer>{
    Set<CourseModule> getAll();
}
