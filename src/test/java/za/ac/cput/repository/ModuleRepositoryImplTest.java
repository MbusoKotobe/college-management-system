/*
 * Zintle Magwaxaza (218109911)
 * ModuleRepositoryImplTest.java
 * Date: 08 April 2022
 */


package za.ac.cput.repository;


import za.ac.cput.repository.entity.Module;
import za.ac.cput.factory.ModuleFactory;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.MethodName.class)

class ModuleRepositoryImplTest {
    private static ModuleRepositoryImpl modulerepositoryImpl = ModuleRepositoryImpl.getModuleRepositoryImpl();
    private static Module module = ModuleFactory.createModule("Multimedia", "Information Technology");


    @Test
    void create() {
        Module create = modulerepositoryImpl.create(module);
        assertEquals(module.getModuleName(), create.getModuleName());
        System.out.println("Create: " + create);
    }

    @Test
    void read() {
        Module read = modulerepositoryImpl.read(module.getModuleId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }


    @Test
    void update() {
        Module update = new Module.Builder()
                .copy(module)
                .setModuleId(module.getModuleId())
                .setModuleName(module.getModuleName())
                .build();
        assertNotNull(modulerepositoryImpl.update(update));
        System.out.println("Update: " + update);
    }


    @Test
    void delete() {
        boolean success = modulerepositoryImpl.delete(module.getModuleId());
        assertTrue(success);
        System.out.println("Delete: " + true);
    }

    @Test
    void getAll() {
        System.out.println("Show: ");
        System.out.println(modulerepositoryImpl.getAll());
    }
}