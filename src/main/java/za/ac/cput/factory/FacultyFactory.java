package za.ac.cput.factory;

import za.ac.cput.repository.entity.Faculty;

public class FacultyFactory
{
    public static Faculty build(long facultyId, String facultyName, String facultyDescription)
    {
        return new Faculty.Builder().setFacultyId(facultyId)
                                    .setFacultyName(facultyName)
                                    .setFacultyDescription(facultyDescription)
                                    .build();
    }
}