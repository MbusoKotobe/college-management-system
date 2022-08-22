package za.ac.cput.service;

import za.ac.cput.entity.Faculty;

public interface IFacultyService extends IService<Faculty, Integer>{
    void deleteById(int facultyId);
}
