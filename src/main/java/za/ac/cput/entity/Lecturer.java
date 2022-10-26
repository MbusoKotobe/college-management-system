package za.ac.cput.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Lecturer.java;
 * This is lecturer domain class
 * Author: Anele Aneal Tose - 216079292
 * Date: 07 April 2022
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
public class Lecturer {
    @Id
    @GeneratedValue
    private long lecturerId;
    private String firstName;
    private String middleName;
    private String lastName;

    protected Lecturer(){}
}