/* Course.java
Entity for the Course
Author: Jody Kearns (209023651)
Date: 06 April 2022 */

package za.ac.cput.entity;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COURSE_TABLE")
public class Course implements Serializable {
    @Id
    private String courseId;
    private String courseName;
    private String courseDescription;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "COURSE_MODULE_TABLE",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private Set<Module> modules = new HashSet<>();

//    private Course(Builder builder){
//        this.courseId = builder.courseId;
//        this.courseName = builder.courseName;
//        this.courseDescription = builder.courseDescription;
//    }

//    public String getCourseId() {
//        return courseId;
//    }
//
//    public String getCourseName() {
//        return courseName;
//    }
//
//    public String getCourseDescription() {
//        return courseDescription;
//    }

//    @Override
//    public String toString() {
//        return "Course{" +
//                "courseId=" + courseId +
//                ", courseName='" + courseName + '\'' +
//                ", courseDescription='" + courseDescription + '\'' +
//                '}';
//    }

//    public static class Builder{
//        private String courseId;
//        private String courseName;
//        private String courseDescription;
//
//        private Set<Module> modules;

//        public Builder setCourseId(String courseId){
//            this.courseId = courseId;
//            return this;
//        }
//
//        public Builder setCourseName(String courseName){
//            this.courseName = courseName;
//            return this;
//        }
//
//        public Builder setCourseDescription(String courseDescription){
//            this.courseDescription = courseDescription;
//            return this;
//        }
//
//        public Builder modules(Set<Module> modules){
//            this.modules = modules;
//            return this;
//        }
//
//
//        public Builder copy(Course course){
//            this.courseId = course.courseId;
//            this.courseName = course.courseName;
//            this.courseDescription = course.courseDescription;
//            return this;
//        }
//
//        public Course build(){
//            return new Course (this);
//        }
//    }
}
