package za.ac.cput.repository.entity;


/*
author: Ameer Ismail
student nr: 218216033
domain: studentCourse entity
ADP 3 Assignment
*/

public class StudentCourse
{
    //private attributes
    private long studentNumber;
    private int courseId;

    private StudentCourse(Builder build)
    {
        this.studentNumber = build.studentNumber;
        this.courseId = build.courseId;
    }

    //getters
    public long getStudentNumber() {
        return studentNumber;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "studentCourse{" +
                "studentNumber=" + studentNumber +
                ", courseId=" + courseId +
                '}';
    }

    //builder class
    public static class Builder
    {
        private long studentNumber;
        private int courseId;

        public Builder setStudentNumber(long studentNumber)
        {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder setCourseId(int courseId)
        {
            this.courseId = courseId;
            return this;
        }

        public Builder copy(StudentCourse studentCourse)
        {
            this.studentNumber = studentCourse.studentNumber;
            this.courseId = studentCourse.courseId;
            return this;
        }

        public StudentCourse build()
        {
            return new StudentCourse(this);
        }
    }
}