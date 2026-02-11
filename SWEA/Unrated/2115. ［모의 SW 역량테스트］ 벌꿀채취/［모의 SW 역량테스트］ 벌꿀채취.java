import java.util.*;
 
public class Solution {
    public static int n ,m, c;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            m = sc.nextInt();
            c = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            // 꿀 채취
            ArrayList<int[]> al = new ArrayList<>(); // 위치별 벌꿀 양 저장하는 리스트
 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j + m - 1 < n; j++) {
                    Integer[] list = new Integer[m]; // 가로로 한번에 저장되는 벌통들
                    for (int k = j; k <= j + m - 1; k++) { // map[i][j] ~ map[i][j + m - 1]까지 저장
                        list[k - j] = map[i][k];
                    }
                    int honey = getHoney(list);
                    al.add(new int[] { i, j, j + m - 1, honey }); // 행, 시작 열, 끝 열, 벌꿀 양
                }
            }
 
            Collections.sort(al, (a, b) -> b[3] - a[3]);
 
            System.out.printf("#%d %d%n", test_case, solve(al));
        }
    }
 
    // 각 벌통 내에서 채취할 수 있는 최대 꿀 구하기
    public static int getHoney(Integer[] list) {
        int limit = c;
        int total = 0;
 
        // dp 사용해서 합이 i일 때 최대 제곱합 구하기
        int[] dp = new int[limit + 1];
        for (int i = 1; i <= limit; i++) dp[i] = -1;
        dp[0] = 0;
 
        for (int l : list) {
            for (int i = limit; i >= l; i--) {
                if (dp[i - l] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - l] + l * l);
                }
            }
        }
        for (int d : dp)
            total = Math.max(total, d);
 
        return total;
    }
 
    public static boolean doNotMeet(int[] list1, int[] list2) {
        int row1 = list1[0], startCol1 = list1[1], endCol1 = list1[2];
        int row2 = list2[0], startCol2 = list2[1], endCol2 = list2[2];
        if (row1 != row2)
            return true;
        for (int i = startCol1; i <= endCol1; i++) {
            for (int j = startCol2; j <= endCol2; j++) {
                if (i == j)
                    return false;
            }
        }
        return true;
    }
 
    public static int solve(ArrayList<int[]> al) {
        for (int i = 0; i < al.size(); i++) {
            for (int j = i + 1; j < al.size(); j++) {
                int[] a = al.get(i);
                int[] b = al.get(j);
                if (a.equals(b))
                    continue;
                if (doNotMeet(a, b)) {
                    return a[3] + b[3];
                }
            }
        }
        return 0;
    }
}