package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Faculty;
import za.ac.cput.factory.FacultyFactory;

import static org.junit.jupiter.api.Assertions.*;

class FacultyRepositoryImplTest
{
    private IFacultyRepository repository = FacultyRepositoryImpl.getFacultyRepository();
    private Faculty faculty = FacultyFactory.createFaculty("Informatics and Design", "Information and visual designing");

    @Test
    void getAll ()
    {
        System.out.println("Showing all faculties");
        System.out.println(repository.getAll());
    }

    @Test
    void create ()
    {
        Faculty faculty = FacultyFactory.createFaculty("Information Technology", "Information management");
        assertEquals(repository.create(faculty).getFacultyName(), faculty.getFacultyName());
    }

    @Test
    void read ()
    {
        Faculty faculty = repository.read(0);
        assertNotNull(faculty);
    }

    @Test
    void update ()
    {
        repository.create(faculty);
        Faculty updatedFaculty = new Faculty.Builder().copy(faculty)
                .setFacultyName("Engineering")
                .build();
        assertNotNull(repository.update(updatedFaculty));
    }

    @Test
    void delete ()
    {
        boolean operationStatus = repository.delete(faculty.getFacultyId());
        assertTrue(operationStatus);
    }
}