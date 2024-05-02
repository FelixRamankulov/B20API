package pojo;

public class AirportAttributesPojo {
    private AirportFromToPojo from_airport;
    private AirportFromToPojo to_airport;
    private Double kilometers;
    private Double miles;
    private Double nautical_miles;

    public AirportFromToPojo getFrom_airport() {
        return from_airport;
    }

    public void setFrom_airport(AirportFromToPojo from_airport) {
        this.from_airport = from_airport;
    }

    public AirportFromToPojo getTo_airport() {
        return to_airport;
    }

    public void setTo_airport(AirportFromToPojo to_airport) {
        this.to_airport = to_airport;
    }

    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }

    public Double getMiles() {
        return miles;
    }

    public void setMiles(Double miles) {
        this.miles = miles;
    }

    public Double getNautical_miles() {
        return nautical_miles;
    }

    public void setNautical_miles(Double nautical_miles) {
        this.nautical_miles = nautical_miles;
    }
}
