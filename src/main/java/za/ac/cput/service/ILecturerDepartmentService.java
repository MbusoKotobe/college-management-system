package za.ac.cput.service;

import za.ac.cput.entity.Lecturer;

import java.util.Optional;

public interface ILecturerDepartmentService extends IService<Lecturer, String>{
    Optional<Lecturer> read(String email);
}
