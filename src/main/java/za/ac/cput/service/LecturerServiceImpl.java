package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.repository.ILecturerRepository;

import java.util.List;
import java.util.Optional;

public class LecturerServiceImpl implements ILecturerService{
    private final ILecturerRepository repository;


    @Autowired
    public LecturerServiceImpl(ILecturerRepository repository){
        this.repository = repository;
    }

    @Override
    public Lecturer save(Lecturer lecturer) {return this.repository.save(lecturer);}

    @Override
    public Optional<Lecturer> read(String id)
    {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Lecturer lecturer) {
        this.repository.delete(lecturer);
    }

    @Override
    public List<Lecturer> findAll() {
        return this.repository.findAll();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<Lecturer> lecturer = read(id);
        if (lecturer.isPresent()) {
            delete(lecturer.get());
        }
    }

}
