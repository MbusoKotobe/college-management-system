package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.entity.LecturerDepartment;

import static org.junit.jupiter.api.Assertions.*;

class LecturerDepartmentFactoryTest {
    @Test
    public void add(){
        LecturerDepartment lD = new LecturerDepartment.Builder().setDepartmentId(255).build();
        assertNotNull(lD);
    }
    @Test
    public void copy(){
        LecturerDepartment lD = new LecturerDepartment.Builder().setDepartmentId(255).build();
        LecturerDepartment lD2 = new LecturerDepartment.Builder().copy(lD).build();
        assertEquals(lD.getDepartmentId(), lD2.getDepartmentId());
    }

}