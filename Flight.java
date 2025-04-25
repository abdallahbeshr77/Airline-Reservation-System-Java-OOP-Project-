package airlinemanagement;

import java.util.ArrayList;

public class Flight
{
    // Instances:
    private int flightNumber;
    private String departure;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int availableSeats;
    private String flightType;
    private ArrayList<Passenger> passengers;
    // Two notes here:
    // 1- There is a Diamond Initialization.
    // 2- ArrayList accept generics. Generics in Java allows to make classes and methods parametrized, Taken as a parameter I mean.

    // Methods:
    public Flight()
    {
        this.passengers = new ArrayList<>();
    }

    public void setFlightNumber(int flightNumber)
    {
        if(flightNumber > 0)
        {
            this.flightNumber = flightNumber;
        }
        else
            throw new IllegalArgumentException("Incorrect Flight Number.");
        /**
        1- throw is a keyword in Java used to explicitly throw an exception.
        2- IllegalArgumentException is a type of exception that indicates an illegal or inappropriate argument passed to a method.
        3- "Incorrect Flight Number." is the message associated with the exception that provides more information about the problem.
        4- In Java, exceptions are objects.
        5- By using throw followed by an exception object (e.g., throw new SomeException("Error message")), you're
           creating an instance of an exception class and signaling that something unexpected or erroneous has
           occurred during program execution.
        */
    }
    public void setDeparture(String departure)
    {
        if(departure instanceof String && departure != null) // Validaion
        {
            this.departure = departure;
        }
        else
            throw new IllegalArgumentException("Incorrect Departure.");
    }
    public void setDestination(String destination)
    {
        if(destination instanceof String && destination != null) // Validaion
        {
            this.destination = destination;
        }
        else
            throw new IllegalArgumentException("Incorrect Destination.");
    }
    public void setDepartureTime(String departureTime)
    {
        // Regex Part computed to make the time string is formated like the following: HH:MM.
        if(departureTime instanceof String && departureTime != null && departureTime.matches("^(?:[0-1][0-9]|2[0-3]):(?:[0-5][0-9])$"))
        {
            this.departureTime = departureTime;
        }
        else
            throw new IllegalArgumentException("Incorrect Departure Time.");
    }

    public void setArrivalTime(String arrivalTime)
    {
        // Regex Part computed to make the time string is formated like the following: HH:MM.
        if(arrivalTime instanceof String && arrivalTime != null && arrivalTime.matches("^(?:[0-1][0-9]|2[0-3]):(?:[0-5][0-9])$"))
        {
            this.arrivalTime = arrivalTime;
        }
        else
            throw new IllegalArgumentException("Incorrect Arrival Time.");
    }

    public void setAvailableSeats(int availableSeats)
    {
        if(availableSeats >= 0)
        {
            this.availableSeats = availableSeats;
        }
        else
            throw new IllegalArgumentException("Incorrect input.");
    }

    public void setFlightType(String flightType)
    {
        if(flightType instanceof String && flightType!= null) // Validation
        {
            this.flightType = flightType;
        }
        else
            throw new IllegalArgumentException("Incorrect input.");
    }

    public String getflightType()
    {
        return flightType;
    }
    public int getFlightNumber()
    {
        return flightNumber;
    }

    public String getDeparture()
    {
        return departure;
    }

    public String getDestination()
    {
        return destination;
    }

    public String getDepartureTime()
    {
        return departureTime;
    }

    public String getArrivalTime()
    {
        return arrivalTime;
    }

    public int getAvailableSeats()
    {
        return availableSeats;
    }

    public ArrayList<Passenger> getPassengers()
    {
        return passengers;
    }
}
