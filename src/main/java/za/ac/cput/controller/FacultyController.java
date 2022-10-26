package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Faculty;
import za.ac.cput.factory.FacultyFactory;
import za.ac.cput.service.IFacultyService;

import java.util.List;

/***
 * FacultyControllerTest.java
 * Controller for Faculty
 * @author Mbuso Kotobe (218040385)
 * Date: 21 August 2022
 */
@Slf4j
@RestController
@RequestMapping("college-management-system/faculty/")
public class FacultyController {

    private final IFacultyService service;

    @Autowired
    public FacultyController (IFacultyService service)
    {
        this.service = service;
    }
    @PostMapping("save")
    public ResponseEntity<Faculty> save(@RequestBody Faculty faculty)
    {
        Faculty facultyReturned = null;
        try{
            facultyReturned = service.save(FacultyFactory.build(
                faculty.getFacultyId(),
                faculty.getFacultyName(),
                faculty.getFacultyDescription()
            ));
        }
        catch(IllegalArgumentException exception)
        {
            log.info("Faculty Save: {}", exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(facultyReturned);
    }

    @GetMapping("read/{facultyId}")
    public ResponseEntity<Faculty> read(@PathVariable long facultyId)
    {
        Faculty facultyReturned = service.read(facultyId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(facultyReturned);
    }

    @GetMapping("find-all")
    public ResponseEntity<List<Faculty>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("delete/{facultyId}")
    public ResponseEntity<Void> deleteById(@PathVariable long facultyId)
    {
        service.deleteById(facultyId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@RequestBody Faculty faculty)
    {
        service.delete(faculty);
        return ResponseEntity.noContent().build();
    }
}
