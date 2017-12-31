import java.util.*;
import java.util.stream.Collectors;

public class Popular3PagePath {

/*
 * Find top 3 of the most popular page by the sorting the path.
 */

    public List<String> popular3PagePath(List<String> paths) {
        HashMap<Character, List<String>> connectedPages = new HashMap<>();
        for (String path : paths) {
            Character user = path.charAt(0);
            String[] pg = path.split(" ");
            List<String> pages = connectedPages.get(user);
            if (pages == null) {
                pages = new ArrayList<>();
                pages.add(pg[1]);
                connectedPages.put(user, pages);
            } else {
                pages.add(pg[1]);
            }
        }

        connectedPages.values().forEach(p -> {
            p.forEach(pg -> System.out.print(pg + ","));
            System.out.println();
        });

        return paths;
    }

    public static void main(String[] args) {
        List<String> paths = Arrays.asList(
            "a-3b7622e, /home",
            "b-128a9d7, /home",
            "a-3b7622e, /deals/spa",
            "b-128a9d7, /deals/car_wash",
            "c-7f8e61a, /deals/seattle",
            "b-128a9d7, /home",
            "d-d682a11, /deals/car_wash",
            "a-3b7622e, /buy",
            "b-128a9d7, /deals/spa",
            "c-7f8e61a, /deals/coffee",
            "b-128a9d7, /buy",
            "c-7f8e61a, /buy");

        Popular3PagePath solution = new Popular3PagePath();
        List<String> popularPath = solution.popular3PagePath(paths);
        System.out.println("The most popular path is " +
            popularPath.stream().collect(Collectors.joining(",")));
    }

}
