package za.ac.cput.factory;

import za.ac.cput.entity.StudentModule;
import za.ac.cput.entity.Module;
import za.ac.cput.utility.Utilities;

public class StudentModuleFactory {

    public static StudentModule createStudentModule (long studentNumber, String moduleId) {

        StudentModule studentModule = new StudentModule.Builder()
                .setModuleId(moduleId)
                .setStudentNumber(studentNumber)
                .build();

        return studentModule;
    }
    }