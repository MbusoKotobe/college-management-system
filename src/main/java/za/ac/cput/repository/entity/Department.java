package za.ac.cput.repository.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import java.util.Set;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

/***
 * Department.java
 * Entity for the Department
 * Author: Ndlangamandla (213063964)
 * Date: 06 April 2022
 */
@Entity
public class Department {
    @Id
    int departmentId;

    String departmentName;

    String departmentDescription;

    @OneToMany(cascade = { PERSIST, MERGE })
    Set<Faculty> faculty;

    protected Department() {  }

    private Department(Builder department)
    {
        this.departmentId = department.departmentId;
        this.departmentName = department.departmentName;
        this.departmentDescription = department.departmentDescription;
    }

    public int getDeparmentId ()
    {
        return departmentId;
    }

    public String getDepartmentName ()
    {
        return departmentName;
    }

    public String getDepartmentDescription ()
    {
        return departmentDescription;
    }

    public Set<Faculty> getFaculty ()
    {
        return faculty;
    }

    public static class Builder{
        int departmentId;
        String departmentName;
        String departmentDescription;
        Set<Faculty> faculty;

        public Builder setDeparmentId (int deparmentId)
        {
            this.departmentId = deparmentId;
            return this;
        }

        public Builder setDepartmentName (String departmentName)
        {
            this.departmentName = departmentName;
            return this;
        }

        public Builder setDepartmentDescription (String departmentDescription)
        {
            this.departmentDescription = departmentDescription;
            return this;
        }

        public Builder setFaculty (Faculty faculty)
        {
            this.faculty.add(faculty);
            return this;
        }

        public Builder copy(Department department)
        {
            this.departmentId = department.departmentId;
            this.departmentName = department.departmentName;
            this.departmentDescription = department.departmentDescription;
            return this;
        }

        public Department build()
        {
            return new Department(this);
        }
    }
}
