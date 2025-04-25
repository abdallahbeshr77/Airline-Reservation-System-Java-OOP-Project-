package airlinemanagement;

public class InternationalFlight extends Flight
{
    // Instances:
    private String internationalDepartureRules= "- Note that Passengers must present valid passports and comply with destination-specific visa requirements before boarding.";

    // Methods:
    public InternationalFlight()
    {
        super();
    }

    public String getinternationalDepartureRules()
    {
        return internationalDepartureRules;
    }
}
