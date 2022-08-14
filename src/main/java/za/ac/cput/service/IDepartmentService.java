
package za.ac.cput.service;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService <T, I> {
    T save(T object);
    Optional<T> read(I id);
    void delete(T object);
    List<T> findAll();
}
