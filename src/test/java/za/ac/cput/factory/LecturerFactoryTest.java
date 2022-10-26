package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Lecturer;

import static org.junit.jupiter.api.Assertions.*;

class LecturerFactoryTest {
    @Test
    public void add(){
        Lecturer l = Lecturer.builder().lecturerId(12252258).firstName("Arinze")
                .lastName("Anikue").build();
        assertNotNull(l);
    }
    @Test
    public void copy(){
        Lecturer l = Lecturer.builder().lecturerId(12252258).firstName("Arinze")
                .lastName("Anikue").build();
        Lecturer l2 = Lecturer.builder().lecturerId(12252258).firstName("Arinze")
                .lastName("Anikue").build();
        assertEquals(l.getFirstName(), l2.getFirstName());
    }
}