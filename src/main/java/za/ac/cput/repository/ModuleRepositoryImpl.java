/*
 * Zintle Magwaxaza (218109911)
 * ModuleRepositoryImpl.java
 * Date: 08 April 2022
 */


package za.ac.cput.repository;
import za.ac.cput.entity.Module;
import java.util.HashSet;
import java.util.Set;


public class ModuleRepositoryImpl implements IModuleRepository {
    private static ModuleRepositoryImpl moduleRepositoryImpl = null;
    private Set<Module> moduleDB;

    private ModuleRepositoryImpl() {
        moduleDB = new HashSet<>();
    }

    public static ModuleRepositoryImpl createModuleRepositoryImpl() {
        if (moduleRepositoryImpl == null) {
            moduleRepositoryImpl = new ModuleRepositoryImpl();
        }
        return moduleRepositoryImpl;
    }

    @Override
    public Set<Module> getAll() {
        return moduleDB;
    }

    @Override
    public Module create(Module object) {
        moduleDB.add(object);
        return object;
    }

    @Override
    public Module read(String id) {
        for(Module module:moduleDB){
            if(module.getModuleId() == id){
                return  module;
            }
        }
        return null;
    }

    @Override
    public Module update(Module module) {
        for (Module i: moduleDB)
            if(i.getModuleId() == module.getModuleId()){
                moduleDB.remove(i);
                moduleDB.add(module);
                return module;
            }
        return null;
    }

    @Override
    public boolean delete(String id) {
        for (Module module : moduleDB)
            if (module.getModuleId() == id) {
                moduleDB.remove(module);
                return true;
            }
        return false;
    }
}


