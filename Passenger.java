package airlinemanagement;

import java.util.ArrayList;

public class Passenger extends Person
{
    private ArrayList<Flight> flightsBooked;
    // Two notes here:
    // 1- There is a Diamond Initialization.
    // 2- ArrayList accept generics. Generics in Java allows to make classes and methods parametrized, Taken as a parameter I mean.

    // Methods:
    public Passenger()
    {
        super();
        this.flightsBooked = new ArrayList<>();
    }

    public void bookFlight(Flight flight)
    {
        flightsBooked.add(flight);
    }

    public void displayBookedFlights()
    {
        if (flightsBooked.isEmpty())
        {
            System.out.println("No bookings found for this passenger.");
        }
        else
        {
            System.out.println("Passenger's Booked Flights:");
            for (int i = 0; i < flightsBooked.size(); i++) {
                Flight flight = flightsBooked.get(i);
                System.out.println("Flight Number: " + flight.getFlightNumber() + " - " + flight.getDeparture() + " to " + flight.getDestination() + ", Departure time: " + flight.getDepartureTime() + ", Arrival Time: " + flight.getArrivalTime() + ", Available seats: " + flight.getAvailableSeats() + ", Type of the flight: " + flight.getflightType());
            }
        }

    }

}