package za.ac.cput.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    private String lastName;
    @ManyToOne
    Department department;

    protected Lecturer(){}

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