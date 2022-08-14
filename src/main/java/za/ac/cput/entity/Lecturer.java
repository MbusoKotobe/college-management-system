package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Lecturer.java;
 * This is lecturer domain class
 * Author: Anele Aneal Tose - 216079292
 * Date: 07 April 2022
 */

@Entity
public class Lecturer {
    @NotNull
    @Id
    private long lecturerId;
    @NotNull
    private String firstName;
    @NotNull
    private String middleName;
    @NotNull
    private String lastName;

    protected Lecturer(){}
    private Lecturer(Builder builder){
        this.lecturerId = builder.lecturerId;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    public long getLecturerId() {

        return lecturerId;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {

        return middleName;
    }
    public String getLastName() {

        return lastName;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerId=" + lecturerId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder{
        private long lecturerId;
        private String firstName;
        private String middleName;
        private String lastName;

        public Builder setLectureId(long lectureId) {
            this.lecturerId = lecturerId;
            return this;
        }

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

        public  Builder copy(Lecturer lecturer){
            this.lecturerId = lecturer.lecturerId;
            this.firstName = lecturer.firstName;
            this.middleName = lecturer.middleName;
            this.lastName = lecturer.lastName;
            return this;
        }
        public Lecturer build(){
            return new Lecturer(this);

        }

    }
}