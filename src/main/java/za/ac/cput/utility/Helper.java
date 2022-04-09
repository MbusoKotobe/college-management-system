package za.ac.cput.utility;

/*
author: Ameer Ismail
student nr: 218216033
Utility: Helper class
ADP 3 Assignment Group1
*/


import java.util.UUID;

public class Helper
{
    public static String generateId()
    {
        return UUID.randomUUID().toString();
    }
}
