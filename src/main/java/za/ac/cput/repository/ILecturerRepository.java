package za.ac.cput.repository;
/**
 * ILecturerRepository.java;
 * This is implemented by LecturerRepository
 * @Author: Anele Aneal Tose - 216079292
 * Date: 09 April 2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Lecturer;

public interface ILecturerRepository extends JpaRepository<Lecturer, Long> {

}
