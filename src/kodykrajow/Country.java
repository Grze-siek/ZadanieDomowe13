package kodykrajow;

public class Country {
    private String countryCode;
    private String countryName;
    private String population;

    public Country(String countryCode, String countryName, String population) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.population = population;
    }

    @Override
    public String toString() {
        return countryName + '(' + countryCode + ") ma " + population + " ludności";
    }
}
