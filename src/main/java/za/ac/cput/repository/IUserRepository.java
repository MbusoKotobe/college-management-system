package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.User;

public interface IUserRepository extends JpaRepository<User, String> {
}
