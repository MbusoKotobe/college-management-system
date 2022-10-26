package za.ac.cput.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/***
 * Faculty.java
 * Entity for the Faculty
 * Author: Mbuso Kotobe (218040385)
 * Date: 06 April 2022
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Faculty
{
    @Id
    @GeneratedValue
    private long facultyId;

    private String facultyName;

    private String facultyDescription;

    @OneToMany
    private Set<Department> departments;

    protected Faculty()
    {
        departments = new HashSet<>();
    }
}
