package za.ac.cput.service;

import za.ac.cput.entity.Module;



public interface IModuleService extends IService<Module,String> {

    void deleteById(String moduleId);
    }

