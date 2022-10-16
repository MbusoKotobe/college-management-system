package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Module;
import za.ac.cput.repository.IModuleRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ModuleServiceImpl implements IModuleService {

        private final IModuleRepository repository;

        @Autowired
        public ModuleServiceImpl(IModuleRepository repository) {
            this.repository = repository;
        }


        @Override
        public Module save(Module module)
        {
            return this.repository.save(module);
        }


        @Override
        public Optional<Module> read(String moduleId)
        {
            return this.repository.findById(moduleId);
        }

        @Override
        public void delete(Module module)
        {
            this.repository.delete(module);
        }


        @Override
        public List<Module> findAll() {
            return this.repository.findAll();
        }

        @Override
        public void deleteById(String moduleId)
        {
            repository.deleteById(moduleId);
        }
    }

