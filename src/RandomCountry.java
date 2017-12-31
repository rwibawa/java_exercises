import java.util.*;

/**
 * Write a method that returns a country name randomly from the following map such that the country with the highest population,
 * has the biggest chance of being randomly selected among all countries. So the probability of a country getting selected is
 * directly proportional to its population.
 */

public class RandomCountry {

    private static Map<String, Long> countryPopulationMap = new HashMap<>();
    private static Random random = new Random();

    static {
        countryPopulationMap.put("China", 1369140000L);
        countryPopulationMap.put("India", 1297063039L);
        countryPopulationMap.put("US", 320646000L);
        countryPopulationMap.put("Indonesia", 13691400L);
        countryPopulationMap.put("Brazil", 204129000L);
        countryPopulationMap.put("Pakistan", 189787000L);
        countryPopulationMap.put("Nigeria", 183583000L);
        countryPopulationMap.put("Bangladesh", 158286000L);
        countryPopulationMap.put("Russia", 146267288L);
        countryPopulationMap.put("Japan", 126910000L);
        countryPopulationMap.put("Mexico", 121005815L);
        countryPopulationMap.put("Philippines", 101256700L);
        countryPopulationMap.put("Vietnam", 90730000L);
        countryPopulationMap.put("Ethiopia", 90076012L);
        countryPopulationMap.put("Egypt", 88311000L);
        countryPopulationMap.put("Germany", 80925000L);
    }

    private static Long threshold = new Long(0);
    private static Set<String> countries = countryPopulationMap.keySet();

    public static void main(String[] args) {

        System.out.println("Total countries: " + countryPopulationMap.size());
        Map<String, Integer> countryCountMap = new HashMap<>();

        String country;
        for (int i = 0; i < 100; i++) {
            country = randomCountry();
            // System.out.println("Country : " + country);
            int currentCount = countryCountMap.get(country) == null ? 0 : countryCountMap.get(country);
            countryCountMap.put(country, currentCount + 1);
        }

        for (Map.Entry<String, Integer> entry : countryCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static String randomCountry() {
        int index = random.nextInt(countries.size());
        // System.out.println("index : " + index);
        String country = null;
        Iterator<String> iterator = countries.iterator();
        for (int i = 0; i <= index; i++) {
            country = iterator.next();
        }

        Long population = countryPopulationMap.get(country);
        if (population < threshold) {
            countries.remove(country);
        } else {
            threshold = population;
        }

        return country;
    }
}

