package za.ac.cput.service;

import za.ac.cput.entity.Faculty;

public interface IFacultyService extends IService<Faculty, Long>{
    void deleteById(Long facultyId);
}
