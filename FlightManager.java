package airlinemanagement;

import java.util.ArrayList;

public class FlightManager extends Person
{
    // Instances:
    private ArrayList<Flight> flights;
    // Two notes here:
    // 1- There is a Diamond Initialization.
    // 2- ArrayList accept generics. Generics in Java allows to make classes and methods parametrized, Taken as a parameter I mean.

    // Methods:
    public FlightManager()
    {
        super();
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight)
    {
        flights.add(flight);
    }

    public boolean checkFlightExistence(int newFlightNumber)
    {
        for (Flight fl : flights) // Enhanced for loop.
        {
            if (fl.getFlightNumber() == newFlightNumber) {
                return true;
            }
        }
        return false;
    }

    public void viewFlights()
    {
        for (Flight flight : flights) // Enhanced for loop.
        {
            System.out.println("Flight Number: " + flight.getFlightNumber() + " - " + flight.getDeparture() + " to " + flight.getDestination() + ", Departure time: "+ flight.getDepartureTime() + ", Arrival Time: " + flight.getArrivalTime() + ", Available seats: " + flight.getAvailableSeats()+ ", Type of the flight: " + flight.getflightType());
        }
    }

    public void bookSeat(Passenger passenger, Flight flight)
    {
        if (flight.getAvailableSeats() > 0)
        {
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            passenger.setFlightNumber(flight.getFlightNumber());
            flight.getPassengers().add(passenger);
            System.out.println("Seat booked successfully for passenger: " + passenger.getName());
        }
        else
            System.out.println("No available seats on this flight.");
    }

    public void cancelReservation(Passenger passenger, Flight flight)
    {
        flight.getPassengers().remove(passenger);
        flight.setAvailableSeats(flight.getAvailableSeats() + 1);
        System.out.println("Reservation canceled for passenger: " + passenger.getName());
    }

    public ArrayList<Flight> getFlights()
    {
        return this.flights;
    }

}
