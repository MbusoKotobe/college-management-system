/* Course.java
Entity for the Course
Author: Jody Kearns (209023651)
Date: 06 April 2022 */

package za.ac.cput.entity;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COURSE_TABLE")
public class Course implements Serializable {
    @Id
    private String courseId;
    private String courseName;
    private String courseDescription;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "COURSE_MODULE_TABLE",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private Set<Module> modules = new HashSet<>();

}
