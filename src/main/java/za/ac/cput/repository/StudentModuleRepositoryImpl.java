
/*
 * Zintle Magwaxaza (218109911)
 * StudentModuleRepositoryImpl.java
 * Date: 08 April 2022
 */


package za.ac.cput.repository;
import za.ac.cput.entity.StudentModule;
import java.util.HashSet;
import java.util.Set;

public class StudentModuleRepositoryImpl implements IStudentModuleRepository{

    private static StudentModuleRepositoryImpl studentModuleRepositoryImpl = null;
    private final Set<StudentModule> studentModuleDB;

    private StudentModuleRepositoryImpl() {
        studentModuleDB = new HashSet<>();
    }
    public static StudentModuleRepositoryImpl createStudentModuleRepositoryImpl(){
        if (studentModuleRepositoryImpl == null){
            studentModuleRepositoryImpl = new StudentModuleRepositoryImpl ();
        }
        return studentModuleRepositoryImpl;
    }
    @Override
    public Set<StudentModule> getAll() {
        return studentModuleDB;
    }
    @Override
    public StudentModule create (StudentModule studentModule) {
        studentModuleDB.add(studentModule);
        return studentModule;
    }

    @Override
    public StudentModule read(long studentNumber, String moduleId) {
        for (StudentModule studentModule : studentModuleDB) {
            if (studentModule.getStudentNumber() == studentNumber &&
                    studentModule.getModuleId() == moduleId) {
                return studentModule;
            }
        }
        return null;
    }
    @Override
    public boolean delete (long studentNumber, String moduleId) {
       StudentModule studentModule = read (studentNumber, moduleId);
        if(studentModule == null)
            return false;
        studentModuleDB.remove(studentModule);
        return true;
    }

}