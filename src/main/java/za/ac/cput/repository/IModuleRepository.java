package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Module;

public interface IModuleRepository extends JpaRepository<Module, String> {

}
