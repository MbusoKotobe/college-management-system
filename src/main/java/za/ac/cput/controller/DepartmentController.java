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
 * Department.java
 * @author Elvis Ndlangamandla (213063964)
 * Date: 21 August 2022
 */

@RestController
@RequestMapping("college-management-system/department/")
@Slf4j
public class DepartmentController {

    private final IDepartmentService departmentService;

    @Autowired
    public DepartmentController(IDepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }


    @PostMapping("save")
    public ResponseEntity<Department> save (@RequestBody Department department)
    {
        log.info("Save Request: ", department);

        Department ValidateDepartment;
        try
        {
            ValidateDepartment = DepartmentFactory.build(department.getDepartmentId(), department.getDepartmentName(),
                    department.getDepartmentDescription(), department.getFaculty());
        }catch (IllegalArgumentException i)
        {
            log.info("Save error: ", i.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Department save = departmentService.save(ValidateDepartment);
        return ResponseEntity.ok(save);

    }


    @GetMapping("read/{id}")
    public ResponseEntity<Department> read(@PathVariable Integer id)
    {
        log.info("Read Request: ", id);
        Department department = this.departmentService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(department);
    }


    @GetMapping("find-all")
    @CrossOrigin(origins = "http://localhost:56734")
    public ResponseEntity<List<Department>> findAll()
    {
        List<Department> departmentLists = this.departmentService.findAll();
        return ResponseEntity.ok(departmentLists);
    }


    @DeleteMapping("delete/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Integer id)
    {
        log.info("Delete Req: ", id);
        this.departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
