package za.ac.cput.repository;

import za.ac.cput.entity.Department;

import java.util.HashSet;
import java.util.Set;

public class DepartmentRepositoryImpl implements IDepartmentRepository
{
    Set<Department> departments;
    IDepartmentRepository repository;

    public DepartmentRepositoryImpl()
    {
        repository = new DepartmentRepositoryImpl();
        departments = new HashSet<Department>();
    }

    @Override
    public Set<Department> getAll ()
    {
        return departments;
    }

    @Override
    public Department create (Department object)
    {
        if(object != null) departments.add(object);
        return object;
    }

    @Override
    public Department read (Integer id)
    {
        return departments.stream()
                .filter(department -> department.getDeparmentId() == id)
                .findAny().orElse(null);
    }

    @Override
    public Department update (Department object)
    {
        Department outdatedDepartment = read(object.getDeparmentId());
        if(outdatedDepartment != null)
        {
            departments.remove(outdatedDepartment);
            departments.add(object);
        }
        return null;
    }

    @Override
    public boolean delete (Integer id)
    {
        Department department = read(id);
        if(department == null) return false;
        else departments.remove(department);
        return true;
    }
}
