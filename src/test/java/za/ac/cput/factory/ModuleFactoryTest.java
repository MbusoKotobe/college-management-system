
/*
 * Zintle Magwaxaza (218109911)
 * ModuleFactoryTest.java
 * Date: 08 April 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Module;
import za.ac.cput.utility.Utilities;

import static org.junit.jupiter.api.Assertions.*;

class ModuleFactoryTest
{

    @Test
    void createModule() {
        Module module = ModuleFactory.createModule(Utilities.generateId(),"Multimedia", "Information Technology");
        assertNotNull(module);
        System.out.println(module);
    }


}
