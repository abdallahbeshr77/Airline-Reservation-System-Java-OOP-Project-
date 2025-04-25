package airlinemanagement;

import java.util.ArrayList;

public class Person
{
    // Instances:
    private String name;
    private int personId;
    private int flightNumber;

    // Methods:
    public Person()
    {

    }
    public void setName(String name)
    {
        if (name instanceof String && name != null) // Validation
        {
            this.name = name;
        }
        else
            throw new IllegalArgumentException("Incorrect name.");
    }

    public void setPersonId(int personId)
    {
        if(personId > 0)
        {
            this.personId = personId;
        }
        else
            throw new IllegalArgumentException("Incorrect ID");
    }

    public void setFlightNumber(int flightNumber)
    {
        if(flightNumber > 0)
        {
            this.flightNumber = flightNumber;
        }
        else
            throw new IllegalArgumentException("Incorrect Flight Number.");
    }

    public String getName()
    {
        return name;
    }

    public int getPersonId()
    {
        return personId;
    }

    public int getFlightNumber()
    {
        return flightNumber;
    }

}