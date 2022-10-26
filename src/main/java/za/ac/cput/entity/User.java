package za.ac.cput.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/***
 * Faculty.java
 * Entity for the Faculty
 * Author: Mbuso Kotobe (218040385)
 * Date: 06 April 2022
 */
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
public class User {
    @Id
    @GeneratedValue
    private String userId;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String userType;

    protected User(){ }
}
