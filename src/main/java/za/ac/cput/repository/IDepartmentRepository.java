package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Department;
/***
 * Department.java
 * @author Elvis Ndlangamandla (213063964)
 * Date: 21 August 2022
 */

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
}
