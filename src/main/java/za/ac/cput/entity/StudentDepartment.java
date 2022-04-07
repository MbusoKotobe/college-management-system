/***
 * Department.java
 * Entity for the Department
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 06 April 2022
 */
package za.ac.cput.entity;

public class StudentDepartment {
    private static long studentNumber;
    private static int departmentId;

    private StudentDepartment (Builder builder) {
        this.studentNumber = studentNumber;
        this.departmentId = departmentId;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;}

    public int getDepartmentId() {
        return departmentId;
    }

   // public void setDepartmentId(int departmentId) {
       // this.departmentId = departmentId;
    //}

    @Override
    public String toString() {
        return "StudentDepartment{" +
                "studentNumber=" + studentNumber +
                ", departmentId=" + departmentId +
                '}';
    }
    public  static  class  Builder {
        private long studentNumber;
        private int departmentId;

        public Builder setStudentNumber(long studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
            return this;
        }


        public Builder copy(StudentDepartment student) {
          this.studentNumber = StudentDepartment.studentNumber;
            this.departmentId = StudentDepartment.departmentId;
            return this;
        }

        public StudentDepartment build() {
            return new StudentDepartment(this);

        }
    }
}
