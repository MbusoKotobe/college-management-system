package za.ac.cput.repository;
/**
 * LecturerRepository.java;
 * This class implement ILecturerRepository
 * @Author: Anele Aneal Tose - 216079292
 * Date: 09 April 2022
 */
import za.ac.cput.entity.Lecturer;

import java.util.HashSet;
import java.util.Set;

public class LecturerRepository implements ILecturerRepository{
    private static LecturerRepository lecturerRepository = null;
    private Set<Lecturer> lecturerDB;
    private LecturerRepository(){
        lecturerDB = new HashSet<>();

    }
    public static LecturerRepository createLectureRepository(){
        if (lecturerRepository == null){
            lecturerRepository = new LecturerRepository();
        }
        return lecturerRepository;
    }
    @Override
    public Set<Lecturer> getAll() {
        return lecturerDB;
    }

    @Override
    public Lecturer create(Lecturer object) {
        lecturerDB.add(object);
        return object;
    }

    @Override
    public Lecturer read(Long id) {
        for(Lecturer lecturer:lecturerDB){
            if(lecturer.getLecturerId() == id){
                return lecturer;
            }
        }
        return null;
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        for (Lecturer i: lecturerDB)
            if(i.getLecturerId() == lecturer.getLecturerId()){
                lecturerDB.remove(i);
                lecturerDB.add(lecturer);
                return lecturer;
            }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        for(Lecturer lecturer: lecturerDB)
            if(lecturer.getLecturerId() == id){
                lecturerDB.remove(lecturer);
                return true;
            }
        return false;
    }
}
