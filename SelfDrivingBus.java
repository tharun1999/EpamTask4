import java.io.*;
import java.util.*;

public class SelfDrivingBus {

    static List<TreeSet<Integer>> adjacent = new ArrayList<>();

    static boolean isConnected(int node, int startInc, int endInc) {
        TreeSet<Integer> neighbors = adjacent.get(node);
        Integer possible = neighbors.higher(startInc - 1);
        return possible != null && possible <= endInc;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; ++i) {
            adjacent.add(new TreeSet<>());
        }
        for (int i = 0; i < n - 1; ++i) {
            int a = s.nextInt() - 1;
            int b = s.nextInt() - 1;
            adjacent.get(a).add(b);
            adjacent.get(b).add(a);
        }
        s.close();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            set.add(i);
        }
        long count = 0;
        for (int i = 2; i <= n && !set.isEmpty(); ++i) {
            count += set.size();
            Set<Integer> nextset = new HashSet<>();
            for (Integer set_ele : set) {
                if (set_ele + i - 1 < n && isConnected(set_ele + i - 1, set_ele, set_ele + i - 2)) {
                    nextset.add(set_ele);
                }
                if (set_ele > 0 && isConnected(set_ele - 1, set_ele, set_ele + i - 2)) {
                    nextset.add(set_ele - 1);
                }
            }
            set = nextset;
        }
        count += set.size();
        System.out.println(count);
    }
}