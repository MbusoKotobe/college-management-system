package za.ac.cput.entity;

/***
 * Department.java
 * Entity for the Department
 * @Author: Mbuso Kotobe (218040385)
 * Date: 06 April 2022
 */
public class Department {
    int deparmentId;
    String departmentName;
    String departmentDescription;
    Faculty faculty;

    private Department(Builder department)
    {
        this.deparmentId = department.deparmentId;
        this.departmentName = department.departmentName;
        this.departmentDescription = department.departmentDescription;
    }

    public int getDeparmentId ()
    {
        return deparmentId;
    }

    public String getDepartmentName ()
    {
        return departmentName;
    }

    public String getDepartmentDescription ()
    {
        return departmentDescription;
    }

    public Faculty getFaculty ()
    {
        return faculty;
    }

    class Builder{
        int deparmentId;
        String departmentName;
        String departmentDescription;
        Faculty faculty;

        public Builder setDeparmentId (int deparmentId)
        {
            this.deparmentId = deparmentId;
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
            this.faculty = faculty;
            return this;
        }

        public Department build()
        {
            return new Department(this);
        }
    }
}
