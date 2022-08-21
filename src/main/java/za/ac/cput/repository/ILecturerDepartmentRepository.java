package za.ac.cput.repository;
/**
 * ILecturerDepartmentRepository.java;
 * This interface is implemented by LecturerDepartmentRepository
 * @Author: Anele Aneal Tose - 216079292
 * Date: 09 April 2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.LecturerDepartment;


public interface ILecturerDepartmentRepository extends JpaRepository<LecturerDepartment,Long> {

}
