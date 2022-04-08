package za.ac.cput.repository;

import za.ac.cput.entity.Lecturer;
import za.ac.cput.entity.LecturerDepartment;

import java.util.HashSet;
import java.util.Set;

public class LecturerDepartmentRepository {
  /**  private static LecturerDepartmentRepository lecturerDepartmentRepository = null;
    private Set<LecturerDepartment> lecturerDepartmentDB;
    private LecturerDepartmentRepository(){
    lecturerDepartmentDB = new HashSet<>();

    }
    public static LecturerDepartmentRepository createLectureDepartmentRepository(){
        if (lecturerDepartmentRepository == null){
            lecturerDepartmentRepository = new LecturerDepartmentRepository();
        }
        return lecturerDepartmentRepository;
    }
    @Override
    public Set<LecturerDepartment> getAll() {
        return lecturerDepartmentDB;
    }

    @Override
    public LecturerDepartment create(LecturerDepartment object) {
        lecturerDepartmentDB.add(object);
        return object;
    }

    @Override
    public LecturerDepartment read(Integer id) {
        for(LecturerDepartment lecturerDepartment:lecturerDepartmentDB){
            if(lecturerDepartment.getLecturerId() && getDepartmentId  == id){
                return lecturerDepartment;
            }
        return null;
    }

    @Override
    public LecturerDepartment update(LecturerDepartment lecturerDepartment) {
        for (LecturerDepartment i: lecturerDepartmentDB)
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
         }*/

    }