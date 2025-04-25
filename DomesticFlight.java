package airlinemanagement;

public class DomesticFlight extends Flight
{
    // Instances:
    private String domesticSecurityProcedures = "- Domestic flights have specific security measures and checks at airports tailored for within-country travel.";

    // Methods:
    public DomesticFlight()
    {
        super();
    }

    public String getDomesticSecurityProcedures()
    {
        return domesticSecurityProcedures;
    }

}
