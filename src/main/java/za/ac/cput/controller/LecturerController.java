package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.service.ILecturerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("college-management-system/lecturer/")
public class LecturerController {

    private final ILecturerService service;

    @Autowired
    public LecturerController(ILecturerService service) {
        this.service = service;
    }
    @PostMapping("save")
    public ResponseEntity<Lecturer> save(@RequestBody Lecturer lecturer){
        Lecturer newLecturer = service.save(lecturer);
        return new ResponseEntity(newLecturer, HttpStatus.CREATED);
    }
    @GetMapping("read/{lecturerId}")
    public ResponseEntity<Lecturer> read(@PathVariable long lecturerId) {
        Lecturer lecturer = service.read(lecturerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(lecturer);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("all")
    public ResponseEntity<List<Lecturer>> findAll(){
        List<Lecturer> lecturers = service.findAll();
        return new ResponseEntity<>(lecturers, HttpStatus.OK);
    }
}
