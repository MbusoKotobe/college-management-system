package za.ac.cput.factory;

import za.ac.cput.entity.Module;
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
