package za.ac.cput.repository;

import za.ac.cput.entity.LecturerDepartment;

import java.util.Set;
//To be re-reconsidered

public interface ILecturerDepartment  extends IRepository<LecturerDepartment,Integer> {
    public Set<LecturerDepartment> getAll();
}
