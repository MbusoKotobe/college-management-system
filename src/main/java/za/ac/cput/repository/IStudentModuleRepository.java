
/*
 * Zintle Magwaxaza (218109911)
 * IStudentModuleRepository.java
 * Date: 08 April 2022
 */

package za.ac.cput.repository;
import za.ac.cput.entity.StudentModule;
import java.util.Set;

public interface IStudentModuleRepository {
    Set<StudentModule> getAll();
   StudentModule create (StudentModule studentModule);
   StudentModule read (long studentNumber, String moduleId);
   boolean delete (long studentNumber, String moduleId);
}
