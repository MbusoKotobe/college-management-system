package za.ac.cput.repository;

/*
author: Ameer Ismail
student nr: 218216033
Repository: IStudentRepository
ADP 3 Assignment Group1
implementation
*/

import za.ac.cput.entity.Student;
import java.util.Set;

public interface IStudentRepository extends IRepository<Student, String>
{
    //CRUD
    Set<Student> getAll();
}
