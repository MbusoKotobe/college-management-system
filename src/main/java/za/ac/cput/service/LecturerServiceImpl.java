package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.repository.ILecturerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerServiceImpl implements ILecturerService {

    private final ILecturerRepository repository;

    @Autowired
    public LecturerServiceImpl(ILecturerRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public Lecturer save(Lecturer object) {
        return repository.save(object);
    }

    @Override
    public Optional<Lecturer> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Lecturer> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Lecturer object) {
        repository.delete(object);
    }

    public void deleteById(long lecturerId) {
        repository.deleteById(lecturerId);
    }
}

