import java.util.*;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            Map<String, Integer> map = new HashMap<>();
             
            for (int i = 0; i < 1000; i++) {
                String n = sc.next();
                if (map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }
            }
 
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
             
            list.sort((e1, e2) -> {
                int cmp = e2.getValue().compareTo(e1.getValue());
                if (cmp != 0) return cmp;
                return e2.getKey().compareTo(e1.getKey());
            });
             
            String value = list.get(0).getKey();
            System.out.printf("#%d %s%n", test_case, value);
        }
    }
}