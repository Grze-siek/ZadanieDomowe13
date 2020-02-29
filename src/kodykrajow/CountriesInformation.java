package kodykrajow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountriesInformation {
    public static void main(String[] args) {
        File file = new File("countriesCodes.csv");
        Map<String, Country> countriesData = loadFileIntoTheMap(file);
        userIntegration(countriesData);
    }

    private static void userIntegration(Map<String, Country> countriesData) {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
        System.out.println("Dostępne kody: PL, DE, IT, FR, DK");
        String userData = input.nextLine();
        switch(userData) {
            case "PL" : {
                System.out.println(countriesData.get("PL").toString());
                break; }
            case "IT" : {
                System.out.println(countriesData.get("IT").toString());
                break;}
            case "DE" : {
                System.out.println(countriesData.get("DE").toString());
                break;}
            case "FR" : {
                System.out.println(countriesData.get("FR").toString());
                break;}
            case "DK" :
                System.out.println(countriesData.get("DK").toString());
        }
        input.close();
    }

    private static Map<String, Country> loadFileIntoTheMap(File file) {
        Map<String, Country> counties = new HashMap<>();
        List<String[]> countiesList = loadCountries(file);
        for (String[] key : countiesList) {
            String code = key[0];
            String countryName = key[1];
            String population = key[2];
            counties.put(code, new Country(code, countryName, population));
        }
        for (Map.Entry<String, Country> country : counties.entrySet())
            System.out.println(country.toString());

        return counties;
    }

    private static List<String[]> loadCountries(File file) {
        Scanner scan = null;
        List<String[]> countriesList = new ArrayList<>();
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String country = scan.nextLine();
                String[] countryArray = country.split(";");
                countriesList.add(countryArray);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(scan != null)
                scan.close();
        }
        return countriesList;
    }
}
