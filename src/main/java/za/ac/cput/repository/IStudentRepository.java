package za.ac.cput.repository;

/*
author: Ameer Ismail
student nr: 218216033
Repository: IStudentRepository
ADP 3 Assignment Group1
implementation
*/

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Student;
public interface IStudentRepository extends JpaRepository<Student, String>
{
}
