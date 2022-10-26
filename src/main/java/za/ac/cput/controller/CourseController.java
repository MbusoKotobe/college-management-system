/* Course.java
Entity for the Course
Author: Jody Kearns (209023651)
Date: 10 October 2022 */

package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Course;
import za.ac.cput.service.courseService.ICourseService;

import java.util.List;

@RestController
@RequestMapping("college-management-system/course/")
@Slf4j
public class CourseController {

    private final ICourseService courseService;
    @Autowired
    public CourseController(ICourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping("save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Course> save(@RequestBody Course course) {
        log.info("Save request for: {}", course);
        Course save;
        try {
            save = courseService.save(course);
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Course> read (@PathVariable String id){
        log.info("Read request: {}", id);
        Course course = this.courseService.read(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(course);
    }

    @GetMapping("find-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Course>> readAll(){
        List<Course> courseList = this.courseService.findAll();
        return ResponseEntity.ok(courseList);
    }

}
