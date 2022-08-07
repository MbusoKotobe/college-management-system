package za.ac.cput.repository;

import za.ac.cput.entity.Faculty;

import java.util.HashSet;
import java.util.Set;

public class FacultyRepositoryImpl implements IFacultyRepository
{
    private Set<Faculty> faculties;
    private static IFacultyRepository repository;

    public FacultyRepositoryImpl()
    {
        faculties = new HashSet<Faculty>();
    }

    public static IFacultyRepository getFacultyRepository ()
    {
        if (repository == null) repository = new FacultyRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Faculty> getAll ()
    {
        return faculties;
    }


    public Faculty create (Faculty object)
    {
        if(object != null) faculties.add(object);
        return object;
    }

    @Override
    public Faculty read (Integer id)
    {

        return faculties.stream()
                        .filter(faculty -> faculty.getFacultyId() == id)
                        .findAny().orElse(null);
    }

    @Override
    public Faculty update (Faculty object)
    {
        Faculty outdatedFaculty = read(object.getFacultyId());
        if(outdatedFaculty != null)
        {
            faculties.remove(outdatedFaculty);
            faculties.add(object);
            return object;
        }
        return null;
    }

    @Override
    public boolean delete (Integer id)
    {
        Faculty faculty = read(id);
        if(faculty == null) return false;
        else faculties.remove(faculty);
        return true;
    }
}
