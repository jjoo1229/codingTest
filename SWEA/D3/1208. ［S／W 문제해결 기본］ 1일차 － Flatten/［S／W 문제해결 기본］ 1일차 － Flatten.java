import java.util.*;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
             
            Integer arr[] = new Integer[100];
            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }
 
            Arrays.sort(arr, Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                arr[0]--;
                arr[99]++;
                Arrays.sort(arr, Collections.reverseOrder());
            }
            int answer = arr[0] - arr[99];
             
            System.out.printf("#%d %d%n", test_case, answer);
        }
    }
}