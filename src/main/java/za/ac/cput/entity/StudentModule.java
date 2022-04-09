package za.ac.cput.entity;


/*
 * Zintle Magwaxaza (218109911)
 * StudentModule.java
 * Date: 08 April 2022
 */

public class StudentModule {
    private long studentNumber;
    private String moduleId;

    private StudentModule(StudentModule.Builder studentModule)
    {
        this.studentNumber = studentModule.studentNumber;
        this.moduleId = studentModule.moduleId;
    }

    public long getStudentNumber ()
    {
        return studentNumber;
    }

    public String getModuleId ()
    {
        return moduleId;
    }

    @Override
    public String toString() {
        return "StudentModule{" +
                "studentNumber='" + studentNumber+ '\'' +
                ", moduleId'" + moduleId + '\'' + '}';
       }

    class Builder{

       private long studentNumber;
       private String moduleId;

        public StudentModule.Builder setStudentNumber (long studentNumber)
        {
            this.studentNumber = studentNumber;
            return this;
        }

        public StudentModule.Builder setModuleId (String moduleId)
        {
            this.moduleId = moduleId;
            return this;
        }

        public StudentModule.Builder copy (StudentModule studentModule) {
            this.studentNumber= studentModule.studentNumber;
            this.moduleId = studentModule.moduleId;
            return this;
        }

        public StudentModule build()
        {
            return new StudentModule(this);
        }
    }

}
