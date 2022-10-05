package za.ac.cput.service.courseService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Course;
import za.ac.cput.repository.ICourseRepository;
import za.ac.cput.service.courseService.ICourseService;
import za.ac.cput.factory.CourseFactory;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository repository;

    @Autowired public CourseServiceImpl(ICourseRepository repository){
        this.repository = repository;
    }

    @Override
    public Course save(Course course) throws IllegalArgumentException {

        Course validatedCourse;
        validatedCourse = CourseFactory.createCourse(
                course.getCourseId(),
                course.getCourseName(),
                course.getCourseDescription(),
                course.getModules());
        return this.repository.save(validatedCourse);
    }

    @Override
    public Optional<Course> read(String id){return this.repository.findById(id);}

    @Override
    public void delete(Course course){this.repository.delete(course);}

    @Override
    public List<Course> findAll(){return this.repository.findAll();}

    @Override
    public void deleteById(String id){
        this.repository.deleteById(id);
        Optional<Course> course = read(id);
        course.ifPresent(this::delete);
    }
}
