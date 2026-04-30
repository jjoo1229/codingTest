import java.io.*;

public class Main {
    public static int n;
    public static String line;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n % 2 != 0) {
            System.out.print("No");
            return;
        }

        line = br.readLine();
        int cnt0 = 0;  // )의 개수
        for (int i = 0; i < n; i++) {
            char c = line.charAt(i);
            if (c == ')') cnt0++;
        }

        // 나간 기록과 들어온 기록은 각각 정확히 n/2여야 한다.
        int need0 = n / 2 - cnt0;  // ?로 표시된 인식 불가된 것 중 나간 기록이어야 하는 기록의 개수
        int check = 0;  // 들어온 직원 수 - 나간 직원 수

        for (int i = n - 1; i >= 0; i--) {  // 뒤에서부터 보면서
            if (line.charAt(i) == ')') {
                check--;
            } else if (line.charAt(i) == '(') {
                check++;
            } else {  // ?인 경우
                if (need0 > 0) {  // 아직 양수라면 나간 기록으로 채우는 게 최선
                    check--;
                    need0--;
                } else {
                    check++;
                }
            }

            if (check > 0) {
                System.out.print("No");
                return;
            }
        }

        if (check == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}