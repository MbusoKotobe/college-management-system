package za.ac.cput.factory;
/***
 * Department.java
 * Entity for the Department
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 06 April 2022
 */
import za.ac.cput.entity.LectureModule;

public class LectureModuleDepartmentFactory {
    public static LectureModule createLectureModule (long lectureId, String moduleId) {

        LectureModule lectureModule = new LectureModule.Builder().setLectureId(lectureId)
                .setModuleId(moduleId)
                .build();
        return lectureModule;
    }
}
