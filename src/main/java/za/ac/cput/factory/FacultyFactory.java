package za.ac.cput.factory;

import za.ac.cput.entity.Faculty;

public class FacultyFactory
{
    public static Faculty build(String facultyName, String facultyDescription)
    {
        return new Faculty.Builder().setFacultyName(facultyName)
                                    .setFacultyDescription(facultyDescription)
                                    .build();
    }
}