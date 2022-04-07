package za.ac.cput.entity;

public class LecturerDepartment {
    private long lecturerId;
    private int departmentId;

        private LecturerDepartment(){}
    private LecturerDepartment(Builder builder){
            this.lecturerId = builder.lecturerId;
            this.departmentId = builder.departmentId;

    }

    public long getLectureId() {
        return lecturerId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public String toString() {
        return "LecturerDepartment{" +
                "lectureId=" + lecturerId +
                ", departmentId=" + departmentId +
                '}';
    }
    public static class Builder{
        private long lecturerId;
        private int departmentId;

        public Builder setLecturerId(long lecturerId){
            this.lecturerId = lecturerId;
            return this;

        }
        public Builder setDepartmentId(int departmentId){
            this.departmentId = departmentId;
            return this;
    }
        public Builder copy(LecturerDepartment lecturerDepartment){
            this.lecturerId = lecturerDepartment.lecturerId;
            this.departmentId = lecturerDepartment.departmentId;
            return this;
        }
        public LecturerDepartment build(){
            return new LecturerDepartment(this);

        }

    }

}