package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Faculty;

/***
 * Faculty.java
 * Entity for the FacultyServiceImplTest
 * @author Mbuso Kotobe (218040385)
 * Date: 14 August 2022
 */
public interface IFacultyRepository extends JpaRepository<Faculty, Integer> {
}
