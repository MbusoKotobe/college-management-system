package za.ac.cput.repository;
/**
 * LecturerDepartmentRepository.java;
 * This class implement LecturerDepartmentRepository
 * @Author: Anele Aneal Tose - 216079292
 * Date: 09 April 2022
 */
import za.ac.cput.repository.entity.LecturerDepartment;
import java.util.HashSet;
import java.util.Set;

public class LecturerDepartmentRepositoryImpl implements ILecturerDepartmentRepository{
    private static LecturerDepartmentRepositoryImpl lecturerDepartmentRepository = null;
    private Set<LecturerDepartment> lecturerDepartmentDB;
    private LecturerDepartmentRepositoryImpl() {
        lecturerDepartmentDB = new HashSet<>();
    }
    public static LecturerDepartmentRepositoryImpl createLectureDepartmentRepository(){
        if (lecturerDepartmentRepository == null){
            lecturerDepartmentRepository = new LecturerDepartmentRepositoryImpl();
        }
        return lecturerDepartmentRepository;
    }
    @Override
    public Set<LecturerDepartment> getAll() {
        return lecturerDepartmentDB;
    }
    @Override
    public LecturerDepartment create(LecturerDepartment lecturerDepartment) {
        lecturerDepartmentDB.add(lecturerDepartment);
        return lecturerDepartment;
    }

    @Override
    public LecturerDepartment read(long lecturerId, int departmentId) {
        for (LecturerDepartment lecturerDepartment : lecturerDepartmentDB) {
            if (lecturerDepartment.getDepartmentId() == departmentId &&
                    lecturerDepartment.getLectureId() == lecturerId) {
                return lecturerDepartment;
            }
        }
        return null;
    }
    @Override
    public boolean delete(long lecturerId, int departmentId) {
        LecturerDepartment lecturerDepartment = read(lecturerId,departmentId);
        if(lecturerDepartment == null)
            return false;
        lecturerDepartmentDB.remove(lecturerDepartment);
        return true;
    }

}