
package za.ac.cput.entity;

import lombok.*;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;


/***
 * Department.java
 * @author Elvis Ndlangamandla (213063964)
 * Date: 21 August 2022
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_description")
    private String departmentDescription;

    @ManyToOne
    Faculty faculty;

    protected Department() { }

}
