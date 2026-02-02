import java.util.*;
import java.io.FileInputStream;

class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int students = sc.nextInt();
        for (int i = 0; i < students; i++) {
            int s = sc.nextInt();
            int num = sc.nextInt();
            
            if (s == 1) {  // 남자면
                for (int j = num; j <= n; j += num) {
                    arr[j - 1] = arr[j - 1] == 1 ? 0 : 1;
                }
            } else if (s == 2) {  // 여자면
                arr[num - 1] = arr[num - 1] == 1 ? 0 : 1;
                for (int j = 1; num - 1 - j >= 0 && num - 1 + j < n; j++) {
                    if (arr[num - 1 - j] != arr[num - 1 + j]) break;
                    arr[num - 1 - j] = arr[num - 1 - j] == 1 ? 0 : 1;
                    arr[num - 1 + j] = arr[num - 1 + j] == 1 ? 0 : 1;
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if ((i + 1) % 20 == 0 || i == arr.length - 1) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }
        System.out.print(sb.toString());
    }
}