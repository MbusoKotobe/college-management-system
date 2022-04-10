package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Faculty;

import static org.junit.jupiter.api.Assertions.*;

class FacultyFactoryTest
{
    @Test
    void createFaculty ()
    {
        Faculty faculty = FacultyFactory.createFaculty("Informatics and Design", "Information and visual designing");
        assertNotNull(faculty);
    }
}