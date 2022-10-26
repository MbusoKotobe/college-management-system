package za.ac.cput.entity;

/*
 * Zintle Magwaxaza (218109911)
 * Module.java
 * Date: 08 April 2022
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name = "MODULE_TABLE")
public class Module {
    @Id
    private String moduleId;

    private String moduleName;
    private String moduleDescription;
}
