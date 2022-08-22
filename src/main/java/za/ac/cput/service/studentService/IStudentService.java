package za.ac.cput.service.studentService;

/*
author: Ameer Ismail
student nr: 218216033
Service interface: IStudentService
ADP 3 Assignment Group1
Service implementation
*/

import za.ac.cput.entity.Student;
import za.ac.cput.service.IService;

public interface IStudentService extends IService<Student, Long>
{
    void deleteById(Long id);
}
