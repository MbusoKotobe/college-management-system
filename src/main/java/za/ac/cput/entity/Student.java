package za.ac.cput.entity;


/*
author: Ameer Ismail
student nr: 218216033
domain: Student entity
ADP 3 Assignment Group1
*/


public class Student {
    // private attributes
    private String firstName;
    private String middleName;
    private String lastName;
    private long studentNumber;


    // builder pattern
    private Student(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.studentNumber = builder.studentNumber;
    }

    //getters
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentNumber=" + studentNumber +
                '}';

    }

    //builder class
    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private long studentNumber;

        //builder setters
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setStudentNumber(long studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        //builder copy
        public Builder copy(Student student) {
            this.firstName = student.firstName;
            this.middleName = student.middleName;
            this.lastName = student.lastName;
            this.studentNumber = student.studentNumber;
            return this;
        }

        public Student build() {
            return new Student(this);

        }
    }
}