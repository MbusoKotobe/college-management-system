package za.ac.cput.entity;

/***
 * Faculty.java
 * Entity for the Faculty
 * Author: Mbuso Kotobe (218040385)
 * Date: 06 April 2022
 */
public class Faculty
{
    int facultyId;
    String facultyName;
    String facultyDescription;

    private Faculty(Builder faculty)
    {
        this.facultyId = faculty.facultyId;
        this.facultyName = faculty.facultyName;
        this.facultyDescription = faculty.facultyDescription;
    }

    public int getFacultyId ()
    {
        return facultyId;
    }

    public String getFacultyName ()
    {
        return facultyName;
    }

    public String getFacultyDescription ()
    {
        return facultyDescription;
    }

    public static class Builder{
        int facultyId;
        String facultyName;
        String facultyDescription;

        public Builder setFacultyId (int facultyId)
        {
            this.facultyId = facultyId;
            return this;
        }

        public Builder setFacultyName (String facultyName)
        {
            this.facultyName = facultyName;
            return this;
        }

        public Builder setFacultyDescription (String facultyDescription)
        {
            this.facultyDescription = facultyDescription;
            return this;
        }

        public Faculty build()
        {
            return new Faculty(this);
        }
    }
}
