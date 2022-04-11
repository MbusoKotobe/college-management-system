package za.ac.cput.repository;

import za.ac.cput.entity.Faculty;

import java.util.Set;

public interface IFacultyRepository extends IRepository<Faculty, Integer>
{
    Set<Faculty> getAll();
}
