package za.ac.cput.utility;

import java.util.UUID;

public class Utilities
{
    public static long generateId(){
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
