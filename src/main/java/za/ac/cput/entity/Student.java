package za.ac.cput.entity;


/*
author: Ameer Ismail
student nr: 218216033
domain: Student entity
ADP 3 Assignment Group1
*/

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Student
{
    // private attributes
    private String firstName;
    private String middleName;
    private String lastName;

    @Id
    private long studentNumber;

    protected Student()
    {}
}