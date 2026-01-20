import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int target = Integer.parseInt(input);   // 답은 target번째 수가 무엇인지를 찾는 것임
        
        int count = 0;
        int current_number = 666;

        while (count < target) {  // 현재까지 센 666을 포함하는 수의 개수랑 target이 같아질 때까지 반복
            String str = Integer.toString(current_number);
            if (str.contains("666")) count++;   // 지금 수(current_number)에 666이 들어가면 count + 1
            current_number++;  // count 셌든 안 셌든 숫자를 늘려가면서 계속 확인
        }
        System.out.print(current_number - 1);
    }
}