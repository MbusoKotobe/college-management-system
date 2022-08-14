package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.repository.ILecturerDepartmentRepository;

import java.util.List;
import java.util.Optional;

public class LecturerDepartmentServiceImpl implements ILecturerDepartmentService{
    private final ILecturerDepartmentRepository repository;


    @Autowired
    public LecturerDepartmentServiceImpl(ILecturerDepartmentRepository repository){
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
