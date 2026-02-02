import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
             
            int answer = 0;
            for (int i = 2; i < n - 2; i++) {
                int[] list = {arr[i-2], arr[i-1], arr[i+1], arr[i+2]};
                int max = 0;
                for (int number : list) {
                    if (number > max) max = number;
                }
                if (arr[i] - max > 0) answer+= arr[i] - max;
            }
            System.out.printf("#%d %d%n", test_case, answer);
        }
    }
}