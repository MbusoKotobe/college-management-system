package za.ac.cput.utility;

public class Utilities
{
    public static long generateId() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
