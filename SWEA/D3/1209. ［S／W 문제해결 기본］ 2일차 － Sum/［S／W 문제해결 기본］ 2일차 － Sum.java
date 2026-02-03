import java.util.*;
import java.io.*;
 
class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            sc.nextInt();
             
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int answer = Integer.MIN_VALUE;
            int sum1 = getRowSum(arr);
            int sum2 = getColSum(arr);
            int sum3 = getCrossSum(arr);
            answer = sum1 > answer ? sum1 : answer;
            answer = sum2 > answer ? sum2 : answer;
            answer = sum3 > answer ? sum3 : answer;
             
            System.out.printf("#%d %d%n", test_case, answer);
        }
    }
 
    public static int getRowSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                sum += arr[i][j];
            }
            max = sum > max ? sum : max;
            sum = 0;
        }
        return max;
    }
 
    public static int getColSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 100; i++) {
                sum += arr[i][j];
            }
            max = sum > max ? sum : max;
            sum = 0;
        }
        return max;
    }
 
    public static int getCrossSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 100; i++) {
            sum1 += arr[i][i];
        }
        for (int i = 0; i < 100; i++) {
            sum2 += arr[i][99 - i];
        }
        max = sum1 > max ? sum1 : max;
        max = sum2 > max ? sum2 : max;
        return max;
    }
}