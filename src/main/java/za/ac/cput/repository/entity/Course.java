/* Course.java
Entity for the Course
Author: Jody Kearns (209023651)
Date: 06 April 2022 */

package za.ac.cput.repository.entity;

public class Course {
    private int courseId;
    private String courseName;
    private String courseDescription;

    private Course(){

    }

    private Course(Builder builder){
        this.courseId = builder.courseId;
        this.courseName = builder.courseName;
        this.courseDescription = builder.courseDescription;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }

    public static class Builder{
        private int courseId;
        private String courseName;
        private String courseDescription;

        public Builder setCourseId(int courseId){
            this.courseId = courseId;
            return this;
        }

        public Builder setCourseName(String courseName){
            this.courseName = courseName;
            return this;
        }

        public Builder setCourseDescription(String courseDescription){
            this.courseDescription = courseDescription;
            return this;
        }

        public Builder copy(Course course){
            this.courseId = course.courseId;
            this.courseName = course.courseName;
            this.courseDescription = course.courseDescription;
            return this;
        }

        public Course build(){
            return new Course (this);
        }
    }
}
