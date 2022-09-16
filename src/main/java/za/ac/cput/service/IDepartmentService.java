package za.ac.cput.service;

import za.ac.cput.entity.Department;

public interface IDepartmentService extends IService<Department, Integer>{
    void deleteById(long lectureId);
}
