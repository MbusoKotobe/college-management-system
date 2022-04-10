package za.ac.cput.utility;

import java.util.UUID;

public class Utilities
{
    public static String generateId(){
        {
            return UUID.randomUUID().toString();
        }
    }
}