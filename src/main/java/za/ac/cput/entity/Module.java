package za.ac.cput.entity;

/*
 * Zintle Magwaxaza (218109911)
 * Module.java
 * Date: 08 April 2022
 */

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "MODULE_TABLE")
public class Module {
    @Id
    private String moduleId;

    private String moduleName;
    private String moduleDescription;

    @ManyToMany(mappedBy = "modules", fetch = FetchType.LAZY)
    private Set<Course> courses;

    protected Module() {
    }
}
