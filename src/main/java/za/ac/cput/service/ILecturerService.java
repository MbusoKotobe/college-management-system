package za.ac.cput.service;

import za.ac.cput.entity.Lecturer;

import java.util.Optional;

public interface ILecturerService extends IService<Lecturer, Long>{
    void deleteById(long lectureId);
}
