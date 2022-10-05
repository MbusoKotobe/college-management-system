package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Faculty;
import za.ac.cput.repository.IFacultyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements IFacultyService {

    IFacultyRepository repository;

    @Autowired
    public FacultyServiceImpl(IFacultyRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Faculty save(Faculty object)
    {
        return repository.save(object);
    }

    @Override
    public Optional<Faculty> read(Long id)
    {
        return repository.findById(id);
    }

    @Override
    public List<Faculty> findAll()
    {
        return repository.findAll();
    }

    @Override
    public void delete(Faculty object)
    {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long facultyId)
    {
        repository.deleteById(facultyId);
    }
}


