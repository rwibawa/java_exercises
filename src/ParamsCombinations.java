import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/*
* URL Path Parameters Combinations.
*/

public class ParamsCombinations {

    public static void main(String[] args) {
        int[][] combinations = new int[][] {
            {0},
            {1},
            {2},
            {0,1},
            {0,2},
            {1,2},
            {0,1,2}
        };

        String[] param = new String[] { "sourceKey", "name", "description"};
        String[] paramValues = new String[] {
            "asset_template_1_US108471_instanceId",
            "asset_template_1_US108471",
            "the simple template"};

        ParamsCombinations solution = new ParamsCombinations();
        System.out.println("AND operator");
        List<String> params = solution.paramsCombinations(":", combinations, param, paramValues);
        params.forEach(p -> System.out.println("?" + p));

        System.out.println("\nOR operator");
        params = solution.paramsCombinations("|", combinations, param, paramValues);
        params.forEach(p -> System.out.println("?" + p));

        System.out.println("\nStart With Parameter Values");
        params = solution.paramsCombinations("|", combinations, param, paramValues);
        params.forEach(p -> System.out.println("?" + p));
    }

    private List<String> paramsCombinations(String separator,
        int[][] combinations, String[] param, String[] paramValues) {
        List<String> result = new ArrayList<>();
        for (int[] indexes : combinations) {
            StringBuilder parameters = new StringBuilder();
            for (int i : indexes) {
                parameters.append(param[i]);
                parameters.append("=");
                try {
                    parameters.append(URLEncoder.encode(paramValues[i], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                parameters.append(separator);
            }

            parameters.delete(parameters.length() - separator.length(), parameters.length());
            result.add(parameters.toString());
        }

        return result;
    }
}
