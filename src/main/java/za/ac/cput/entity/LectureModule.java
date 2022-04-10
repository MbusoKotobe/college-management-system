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


    private LectureModule(Builder builder) {
        this.lectureId = builder.lectureId;
        this.moduleId = builder.moduleId;
    }

    public long getLectureId() {
        return lectureId;
    }


    public String getModuleId() {
        return moduleId;
    }

    public void setLectureId(long lectureId) {
        this.lectureId = lectureId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public static class Builder {
        private long lectureId;
        private String moduleId;

        public Builder setLectureId(long lectureId) {
            this.lectureId = lectureId;
            return this;
        }

        public Builder setModuleId(String moduleId) {
            this.moduleId = moduleId;
            return this;
        }
        public LectureModule build (){
           return new LectureModule(this);
        }
    }
}
