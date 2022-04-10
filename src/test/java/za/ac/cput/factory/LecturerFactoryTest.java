package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Lecturer;

import static org.junit.jupiter.api.Assertions.*;

class LecturerFactoryTest {
    @Test
    public void add(){
        Lecturer l = new Lecturer.Builder().setLectureId(12252258).setFirstName("Arinze")
                .setLastName("Anikue").build();
        assertNotNull(l);
    }
    @Test
    public void copy(){
        Lecturer l = new Lecturer.Builder().setLectureId(12252258).setFirstName("Arinze")
                .setLastName("Anikue").build();
        Lecturer l2 = new Lecturer.Builder().copy(l).build();
        assertEquals(l.getFirstName(), l2.getFirstName());
    }
}