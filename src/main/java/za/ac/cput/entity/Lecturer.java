package za.ac.cput.entity;

/**
 * Lecturer.java;
 * This is lecturer domain class
 * @Author: Anele Aneal Tose - 216079292
 * Date: 07 April 2022
 */

public class Lecturer {
    private long lecturerId;
    private String firstName;
    private String lastName;

    //Add private constructors
    private Lecturer(){}
    private Lecturer(Builder builder){
        this.lecturerId = builder.lecturerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public long getLecturerId() {

        return lecturerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerId='" + lecturerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    public static class Builder{
        private long lecturerId;
        private String firstName;
        private String lastName;

        public Builder setLectureId(long lectureId) {
            this.lecturerId = lecturerId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public  Builder copy(Lecturer lecturer){
            this.lecturerId = lecturer.lecturerId;
            this.firstName = lecturer.firstName;
            this.lastName = lecturer.lastName;
            return this;
        }
        public Lecturer build(){
            return new Lecturer(this);

        }

    }
}