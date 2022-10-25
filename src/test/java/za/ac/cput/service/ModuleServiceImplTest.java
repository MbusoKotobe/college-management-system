package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.factory.ModuleFactory;
import za.ac.cput.entity.Module;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ModuleServiceImplTest {

    Module module = ModuleFactory.createModule("ADT", "Applications Development ","Applications Development Theory");

    @Autowired
    private IModuleService moduleService;

    @Test
    @Order(1)
    void save()
    {
        Module created = this.moduleService.save(this.module);
        assertEquals(this.module, created);
        System.out.println(created);

    }

    @Test
    @Order(2)
    void read()
    {
        Optional<Module> read = this.moduleService.read(module.getModuleId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.module, read.get())
        );
        System.out.println(read);
    }

    @Test
    @Order(3)
    void findAll()
    {
        List<Module> moduleList = this.moduleService.findAll();
        assertEquals(1, moduleList.size());
        System.out.println(moduleList);
    }

    @Test
    @Order(4)
    void delete()
    {
        this.moduleService.deleteById(this.module.getModuleId());
        List<Module> moduleList = this.moduleService.findAll();
        assertEquals(0, moduleList.size());
    }

}

