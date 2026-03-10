import java.io.*;
import java.util.*;
 
public class Solution {
    public static int t, n;
    public static HashMap<String, Integer> map;
    public static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        map = new HashMap<String, Integer>();
        map.put("ZRO", 0);
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THR", 3);
        map.put("FOR", 4);
        map.put("FIV", 5);
        map.put("SIX", 6);
        map.put("SVN", 7);
        map.put("EGT", 8);
        map.put("NIN", 9);
 
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            n = Integer.parseInt(st.nextToken());
            String[] list = new String[n];
 
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list[i] = st2.nextToken();
            }
            Arrays.sort(list, (a, b) -> map.get(a) - map.get(b));
            sb.append("#").append(tc).append("\n");
            for (int i = 0; i < n; i++) {
                sb.append(list[i]).append(" ");
            }
            sb.append("\n");
        }
 
        System.out.print(sb.toString());
    }
}