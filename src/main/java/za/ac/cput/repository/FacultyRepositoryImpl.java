package za.ac.cput.repository;

import za.ac.cput.entity.Faculty;

import java.util.HashSet;
import java.util.Set;

public class FacultyRepositoryImpl implements IFacultyRepository
{
    Set<Faculty> faculties;
    IRepository repository;

    public FacultyRepositoryImpl()
    {
        repository = new FacultyRepositoryImpl();
        faculties = new HashSet<Faculty>();
    }

    @Override
    public Set<Faculty> getAll ()
    {
        return faculties;
    }

    @Override
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
