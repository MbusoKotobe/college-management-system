package za.ac.cput.repository;

import za.ac.cput.entity.Department;

import java.util.Set;

public interface IDepartmentRepository extends IRepository<Department, Integer>
{
    Set<Department> getAll();
}
