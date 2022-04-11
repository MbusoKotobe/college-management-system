/*
 * Zintle Magwaxaza (218109911)
 * ModuleTest.java
 * Date: 08 April 2022
 */


package za.ac.cput.entity;
import org.junit.jupiter.api.Test;

public class ModuleTest {

    @Test
    public void testBuilder(){
        Module module = new Module.Builder()
                .setModuleId("MUT327")
                .setModuleName("Multimedia")
                .setModuleDescription("Information Technology")
                .build();
        System.out.println("Module: " + module);
    }

}
