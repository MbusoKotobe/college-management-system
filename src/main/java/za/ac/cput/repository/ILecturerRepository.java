package za.ac.cput.repository;
/**
 * ILecturerRepository.java;
 * This is implemented by LecturerRepository
 * @Author: Anele Aneal Tose - 216079292
 * Date: 09 April 2022
 */
import za.ac.cput.repository.entity.Lecturer;

import java.util.Set;

public interface ILecturerRepository extends IRepository<Lecturer,Long>{
    public Set<Lecturer> getAll();
}
