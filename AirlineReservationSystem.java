package airlinemanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class AirlineReservationSystem
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in); // Scanner object.
        FlightManager manager = new FlightManager(); // Our manager which is FlightManager object.
        Flight bookFlight = null; // Not initialized yet, but declared here to avoid being local scoped.
        ArrayList<Passenger> passengers = new ArrayList<>(); // ArrayList of passengers, each index is a Passenger object.

        System.out.println("Welcome to Airline Reservation System!");
        int choice;
        do
        {
            System.out.println("1. Add Flight\n2. View Flights\n3. Book Seat\n4. View booked Flights\n5. Cancel Reservation\n6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // To consume new line left in input buffer
            switch (choice)
            {
                case 1:
                    System.out.println("Adding Flight:");
                    System.out.println("Select the type of flight:");
                    System.out.println("1. Domestic Flight(within the borders of a specific country).\n2. International Flight(operating between airports in different countries).");
                    System.out.print("Enter your choice: ");
                    int flightType = scanner.nextInt();
                    scanner.nextLine(); // To consume new line left in input buffer
                    if(flightType == 1)
                    {
                        DomesticFlight flight = new DomesticFlight();
                        flight.setFlightType("Domestic Flight");
                        System.out.print("Enter flight number: ");
                        int flightNumber = scanner.nextInt();
                        boolean flightExistance= manager.checkFlightExistence(flightNumber);
                        if(flightExistance)
                        {
                            System.out.println("Flight already exist.");
                        }
                        else
                        {
                            scanner.nextLine();
                            flight.setFlightNumber(flightNumber);

                            System.out.print("Enter departure location: ");
                            String departure = scanner.nextLine();
                            flight.setDeparture(departure);

                            System.out.print("Enter destination: ");
                            String destination = scanner.nextLine();
                            flight.setDestination(destination);

                            System.out.print("Enter departure time (HH:MM): ");
                            String departureTime = scanner.nextLine();
                            flight.setDepartureTime(departureTime);

                            System.out.print("Enter arrival time (HH:MM): ");
                            String arrivalTime = scanner.nextLine();
                            flight.setArrivalTime(arrivalTime);

                            System.out.print("Enter available seats: ");
                            int availableSeats = scanner.nextInt();
                            flight.setAvailableSeats(availableSeats);

                            manager.addFlight(flight);  // Adding flight made to the ArrayList of flights in the FlightManager class.
                            System.out.println("Flight added successfully!");
                        }
                    }
                    else if(flightType == 2)
                    {
                        InternationalFlight flight = new InternationalFlight();
                        flight.setFlightType("International Flight");
                        System.out.println(flight.getinternationalDepartureRules());
                        System.out.print("Enter flight number: ");
                        int flightNumber = scanner.nextInt();
                        boolean flightExistance= manager.checkFlightExistence(flightNumber);
                        if(flightExistance)
                        {
                            System.out.println("Flight already exist.");
                        }
                        else {
                            scanner.nextLine();
                            flight.setFlightNumber(flightNumber);

                            System.out.print("Enter departure country: ");
                            String departure = scanner.nextLine();
                            flight.setDeparture(departure);

                            System.out.print("Enter destination country: ");
                            String destination = scanner.nextLine();
                            flight.setDestination(destination);

                            System.out.print("Enter departure time (HH:MM): ");
                            String departureTime = scanner.nextLine();
                            flight.setDepartureTime(departureTime);

                            System.out.print("Enter arrival time (HH:MM): ");
                            String arrivalTime = scanner.nextLine();
                            flight.setArrivalTime(arrivalTime);

                            System.out.print("Enter available seats: ");
                            int availableSeats = scanner.nextInt();
                            flight.setAvailableSeats(availableSeats);

                            manager.addFlight(flight); // Adding flight made to the ArrayList of flights in the FlightManager class.
                            System.out.println("Flight added successfully!");
                        }
                    }
                    else
                        System.out.println("Invalid flight type.");
                    break;

                case 2:
                    System.out.println("Viewing Flights:");
                    manager.viewFlights();
                    break;

                case 3:
                    System.out.println("Booking Seat:");
                    System.out.print("Enter flight number: ");
                    int flightNum = scanner.nextInt();
                    scanner.nextLine();

                    for (Flight fl : manager.getFlights()) // Enhanced for loop.
                    {
                        if (fl.getFlightNumber() == flightNum)
                        {
                            bookFlight = fl;
                            break;
                        }
                    }

                    if (bookFlight != null && bookFlight.getAvailableSeats() > 0)
                    {
                        System.out.print("Enter passenger name: ");
                        String passengerName = scanner.nextLine();

                        System.out.print("Enter passenger ID: ");
                        int passengerId = scanner.nextInt();
                        scanner.nextLine();

                        Passenger passenger = new Passenger();
                        passenger.setName(passengerName);
                        passenger.setPersonId(passengerId);

                        manager.bookSeat(passenger, bookFlight);
                        passengers.add(passenger); // Adding passenger made to the ArrayList of passengers.
                        passenger.bookFlight(bookFlight); // Adding flight made to the ArrayList of flights in Passenger class.
                    }
                    else
                    {
                        System.out.println("Flight not found or all seats are booked.");
                    }
                    break;

                case 4:
                    System.out.print("Enter passenger ID: ");
                    int passengerIdToView = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    boolean foundPassenger = false;
                    for (Passenger p : passengers) // Enhanced for loop.
                    {
                        if (p.getPersonId() == passengerIdToView) {
                            p.displayBookedFlights();
                            foundPassenger = true;
                            break;
                        }
                    }

                    if (!foundPassenger) {
                        System.out.println("Passenger not found or unauthorized access!");
                    }
                    break;

                case 5:
                    System.out.println("Canceling Reservation:");
                    System.out.print("Enter passenger ID: ");
                    int cancelId = scanner.nextInt();
                    scanner.nextLine();

                    Passenger cancelPassenger = null;
                    for (Flight fl : manager.getFlights()) // Enhanced for loop.
                    {
                        for (Passenger p : fl.getPassengers()) // Enhanced for loop.
                        {
                            if (p.getPersonId() == cancelId)
                            {
                                cancelPassenger = p;
                                bookFlight = fl;
                                break;
                            }
                        }
                        if (cancelPassenger != null)
                        {
                            break;
                        }
                    }

                    if (cancelPassenger != null && bookFlight != null)
                    {
                        manager.cancelReservation(cancelPassenger, bookFlight);
                        passengers.remove(cancelPassenger);
                    }
                    else
                    {
                        System.out.println("Passenger or Flight not found!");
                    }
                    break;
                case 6:
                    System.out.println("Exiting Airline Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
