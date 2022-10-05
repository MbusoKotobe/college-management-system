/* CourseModule.java
Entity for the CourseModule
Author: Jody Kearns (209023651)
Date: 06 April 2022 */

package za.ac.cput.entity;

public class CourseModule {
    private int courseId;
    private String moduleId;

    private CourseModule(){

    }

    private CourseModule(Builder builder){
        this.courseId = builder.courseId;
        this.moduleId = builder.moduleId;
    }


    public int getCourseId() {
        return courseId;
    }

    public String getModuleId() {
        return moduleId;
    }

    @Override
    public String toString() {
        return "CourseModule{" +
                "courseId=" + courseId +
                ", moduleId='" + moduleId + '\'' +
                '}';
    }

    public static class Builder{
        private int courseId;
        private String moduleId;

        public CourseModule.Builder setCourseId(int courseId){
            this.courseId = courseId;
            return this;
        }

        public CourseModule.Builder setModuleId(String moduleId){
            this.moduleId = moduleId;
            return this;
        }


        public CourseModule.Builder copy(CourseModule courseModule){
            this.courseId = courseModule.courseId;
            this.moduleId = courseModule.moduleId;
            return this;
        }

        public CourseModule build(){
            return new CourseModule (this);
        }
    }
}
