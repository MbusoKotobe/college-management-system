package za.ac.cput.factory;

/*
 * Zintle Magwaxaza (218109911)
 * ModuleFactory.java
 * Date: 08 April 2022
 */


import za.ac.cput.repository.entity.Module;
import za.ac.cput.utility.Utilities;


    public class ModuleFactory {

            public static Module createModule (String moduleName,String moduleDescription)
            {
                String ModuleId = Utilities.generateId();

                Module module = new Module.Builder().setModuleId(ModuleId)
                        .setModuleName(moduleName)
                        .setModuleDescription(moduleDescription)
                        .build();
                return module;
            }
}
