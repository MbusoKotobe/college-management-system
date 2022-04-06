package za.ac.cput.entity;

/***
 * Faculty.java
 * Entity for the Faculty
 * @Author: Mbuso Kotobe (218040385)
 * Date: 06 April 2022
 */
public class Faculty
{
    int facultyId;
    String facultyName;
    String facultyDescription;

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
}
