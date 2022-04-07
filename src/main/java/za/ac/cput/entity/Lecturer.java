package za.ac.cput.entity;

public class Lecturer {
    private long lecturerId;
    private String firstName;
    private String middleName;
    private String lastName;

    //Add private constructors
    private Lecturer(){}
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

    public String getMiddleNameName() {
        return middleName;
    }

    public String getLastName() {

        return lastName;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerId='" + lecturerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", firstName='" + middleName + '\'' +
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
            return new Lecturer(this);  //anonymos object

        }

    }
}