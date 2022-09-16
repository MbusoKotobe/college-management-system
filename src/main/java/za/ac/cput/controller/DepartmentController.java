package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Department;
import za.ac.cput.factory.DepartmentFactory;
import za.ac.cput.service.IDepartmentService;
import java.util.List;

/***
 * DepartmentController.java
 * Controller for Department
 * @author Elvis Ndlangamandla (213063964)
 * Date: 21 August 2022
 */

@Slf4j
@RestController
@RequestMapping ("college-management/department")
public class DepartmentController {
    private final IDepartmentService iDepartmentService;

    @Autowired
    public DepartmentController (IDepartmentService iDepartmentService)
    {
        this.iDepartmentService = iDepartmentService;
    }

    @PostMapping("save")
    public ResponseEntity<Department> save(@RequestBody Department department)
    {
        Department departmentReturned = null;
        try{
            departmentReturned = iDepartmentService.save(DepartmentFactory.build(
                    department.getDeparmentId(),
                    department.getDepartmentName(),
                    department.getDepartmentDescription()
            ));
        }
        catch(IllegalArgumentException exception)
        {
            log.info("Department Save: {}", exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(departmentReturned);
    }

    @GetMapping("read/{departmentId}")
    public ResponseEntity<Department> read(@PathVariable int departmentId)
    {
        Department departmentReturned = iDepartmentService.read(departmentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(departmentReturned);
    }

    @GetMapping("find-all")
    public ResponseEntity<List<Department>> findAll()
    {
        return ResponseEntity.ok(iDepartmentService.findAll());
    }

    @DeleteMapping("delete/{departmentId}")
    public ResponseEntity<Void> deleteById(@PathVariable int departmentId)
    {
        iDepartmentService.deleteById(departmentId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@RequestBody Department department)
    {
        iDepartmentService.delete(department);
        return ResponseEntity.noContent().build();
    }
}
