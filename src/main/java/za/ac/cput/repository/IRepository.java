package za.ac.cput.repository;

import java.util.ArrayList;

public interface IRepository <T, I>
{
    T add(T object);
    T get(I id);
    T update(T object);
    boolean remove(I id);
}
