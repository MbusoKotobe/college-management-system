
/*
 * Zintle Magwaxaza (218109911)
 * IModuleRepository.java
 * Date: 08 April 2022
 */

package za.ac.cput.repository;
import za.ac.cput.repository.entity.Module;

import java.util.Set;

public interface IModuleRepository extends IRepository<Module,String>
{
    public Set<Module> getAll();

    Module update(Module module);
}