
package za.ac.cput.entity;

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
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int departmentId;

   @Column(name = "department_name")
    private String departmentName;
    @Column(name = "department_description")
    private String departmentDescription;

    @OneToMany(cascade = { PERSIST, MERGE })
    private Set<Department> departments;

    @ManyToOne
    Faculty faculty;

    protected Department() {
        departments=new HashSet<>();
    }

    private Department(Builder department)
    {
        this.departmentId = department.departmentId;
        this.departmentName = department.departmentName;
        this.departmentDescription = department.departmentDescription;
        this.faculty = department.faculty;
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

    public Set<Department> getFaculty ()
    {
        return departments;
    }


    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentDescription='" + departmentDescription + '\'' +
                ", departments=" + departments +
                ", faculty=" + faculty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentId == that.departmentId && Objects.equals(departmentName, that.departmentName) && Objects.equals(departmentDescription, that.departmentDescription) && Objects.equals(departments, that.departments) && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, departmentDescription, departments, faculty);
    }

    public static class Builder{
        int departmentId;
        String departmentName;
        String departmentDescription;
        Faculty faculty;


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
            this.faculty= faculty;
            return this;
        }

        public Builder copy(Department department)
        {
            this.departmentId = department.departmentId;
            this.departmentName = department.departmentName;
            this.departmentDescription = department.departmentDescription;
            this.faculty = department.faculty;
            return this;
        }

        public Department build()
        {
            return new Department(this);
        }
    }
}
