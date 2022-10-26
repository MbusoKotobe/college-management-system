package za.ac.cput.factory;

/*
 * Zintle Magwaxaza (218109911)
 * ModuleFactory.java
 * Date: 08 April 2022
 */


import za.ac.cput.entity.Module;
import za.ac.cput.utility.Utilities;


    public class ModuleFactory {

            public static Module createModule (String moduleId, String moduleName,String moduleDescription)
            {

                return Module.builder().moduleId(moduleId)
                        .moduleName(moduleName)
                        .moduleDescription(moduleDescription)
                        .build();
            }
}
