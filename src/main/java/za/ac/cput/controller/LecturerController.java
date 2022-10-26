package za.ac.cput.controller;
/***
 * LecturerController.java
 * Controller for Lecturer
 * @author Anele Aneal Tose (216079292)
 * Date: 23 August 2022
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.factory.LecturerFactory;
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
        Lecturer lecturerReturned = null;
        try{
            lecturerReturned = service.save(LecturerFactory.createLecturer(
                    lecturer.getLecturerId(),
                    lecturer.getFirstName(),
                    lecturer.getMiddleName(),
                    lecturer.getLastName()
            ));
        }
        catch(IllegalArgumentException exception)
        {
            log.info("Lecturer Save: {}", exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(lecturerReturned);
    }
    @GetMapping("read/{lecturerId}")
    public ResponseEntity<Lecturer> read(@PathVariable long lecturerId) {
        Lecturer lecturerReturned = service.read(lecturerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(lecturerReturned);
    }
    @GetMapping("find-all")
    public ResponseEntity<List<Lecturer>> findAll(){
        List<Lecturer> lecturers = service.findAll();
        return new ResponseEntity<>(lecturers, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@RequestBody Lecturer lecturer)
    {
        service.delete(lecturer);
        return ResponseEntity.noContent().build();
    }

}
