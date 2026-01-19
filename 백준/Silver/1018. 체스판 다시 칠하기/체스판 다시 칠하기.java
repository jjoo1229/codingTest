import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        char[][] arr = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray(); // 한 줄을 바로 char 배열로 변환
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int result = getAnswer(i, j, arr);
                answer = Math.min(result, answer);
            }
        }
        System.out.print(answer);
    }

    public static int getAnswer(int startRow, int startCol, char[][] arr) {
        char color = arr[startRow][startCol];    // 첫번째 칸 색
        int count = 0;
    
        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8; j++) {
                if (arr[i][j] != color) count++;
                color = (color == 'W') ? 'B' : 'W';    // 색 바꾸기
            }
            color = (color == 'W') ? 'B' : 'W';  // 행이 넘어갈 때도 색을 바꿔준다
        }
        return Math.min(count, 64 - count);
    }
}