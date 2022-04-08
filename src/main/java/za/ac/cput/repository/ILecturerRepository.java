package za.ac.cput.repository;

import za.ac.cput.entity.Lecturer;

import java.util.Set;

public interface ILecturerRepository extends IRepository<Lecturer,Long>{
    public Set<Lecturer> getAll();
}
