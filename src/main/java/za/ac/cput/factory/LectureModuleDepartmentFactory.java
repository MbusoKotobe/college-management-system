package za.ac.cput.factory;

import za.ac.cput.entity.LectureModule;
import za.ac.cput.entity.StudentDepartment;

public class LectureModuleDepartmentFactory {
    public static LectureModule createLectureModule (long lectureId, String moduleId) {

        LectureModule lectureModule = new LectureModule.Builder().setLectureId(lectureId)
                .setModuleId(moduleId)
                .build();
        return lectureModule;
    }
}
