package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Module;
import za.ac.cput.factory.ModuleFactory;
import za.ac.cput.service.IModuleService;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("college-management-system/module/")
public class ModuleController {

    private final IModuleService moduleService;

    @Autowired
    public ModuleController(IModuleService moduleService)
        {
            this.moduleService = moduleService;
        }

        @PostMapping("save")
        public ResponseEntity<Module> save (@RequestBody Module module)
        {
            log.info("Save Request: {}", module);

            Module ValidateModule;
            try {
                ValidateModule = ModuleFactory.createModule(module.getModuleId(),module.getModuleName(),
                        module.getModuleDescription());
            } catch (IllegalArgumentException i) {
                log.info("Save error: {}", i.getMessage());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            Module save = moduleService.save(ValidateModule);
            return ResponseEntity.ok(save);

        }


        @GetMapping("read/{id}")
        public ResponseEntity<Module> read (@PathVariable String id)
        {
            log.info("Read Request: {}", id);
            Module module = this.moduleService.read(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            return ResponseEntity.ok(module);
        }

        @GetMapping("find-all")
        public ResponseEntity<List<Module>> findAll ()
        {
            List<Module> moduleLists = this.moduleService.findAll();
            return ResponseEntity.ok(moduleLists);
        }


        @DeleteMapping("delete/{id}")
        public ResponseEntity<Void> delete (@PathVariable String id)
        {
            log.info("Delete Req: {}", id);
            this.moduleService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }
