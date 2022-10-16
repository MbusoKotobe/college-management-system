
/*
 * Zintle Magwaxaza (218109911)
 * IStudentModuleRepository.java
 * Date: 08 April 2022
 */

package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Faculty;
import za.ac.cput.entity.StudentModule;
import java.util.Set;

public interface IStudentModuleRepository extends JpaRepository<StudentModule, String> {

}

