import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        int i = singleNumber(a);
        System.out.println(i);
    }

    private static int singleNumber(final List<Integer> a) {
        Set<Integer> set = new HashSet<>();
        a.forEach(i -> {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        });

        return (int)set.toArray()[0];
    }
}
