import java.util.*;

class SparseArrays {

    static int[] matchingStrings(String[] strings, String[] queries) {
        HashMap<String, Integer> strings_map = new HashMap<>();
        int[] solution = new int[queries.length];

        for (String str : strings) {
            strings_map.put(str, strings_map.getOrDefault(str, 0) + 1);
        }

        int i = 0;
        for (String str : queries) {
            solution[i] = strings_map.getOrDefault(str, 0);
            i++;
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int strings_length = s.nextInt();
        String[] strings = new String[strings_length];
        for (int i = 0; i < strings_length; i++) {
            strings[i] = s.next();
        }

        int queries_length = s.nextInt();
        String[] queries = new String[queries_length];
        for (int i = 0; i < queries_length; i++) {
            queries[i] = s.next();
        }
        s.close();

        int[] answer = matchingStrings(strings, queries);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}