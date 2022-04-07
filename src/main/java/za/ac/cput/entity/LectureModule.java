/***
 * Department.java
 * Entity for the Department
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 06 April 2022
 */
package za.ac.cput.entity;

public class LectureModule {
    private long lectureId;
    private String moduleId;

    private LectureModule (StudentDepartment.Builder builder) {
        this.lectureId = lectureId;
        this.moduleId = moduleId;
    }

    public long getLectureId() {
        return lectureId;
    }

    public void setLectureId(long lectureId) {
        this.lectureId = lectureId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }


}
