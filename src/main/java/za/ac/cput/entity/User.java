package za.ac.cput.entity;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

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
public class User {
    @Id
    @GeneratedValue
    private String userId;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String userType;

    @Null
    private String usernameErrorMessage;

    @Null
    private String passwordErrorMessage;

    protected User(){ }
}
