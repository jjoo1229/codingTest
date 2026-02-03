import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        for (int i = 0; i < k; i++) {
            max += arr[i];
        }
        
        int value = max;
        for (int i = k; i < n; i++) {
            value += arr[i] - arr[i - k];
            max = max < value ? value : max;
        }
        System.out.print(max);
    }
}