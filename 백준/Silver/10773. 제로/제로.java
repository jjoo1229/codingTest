import java.util.*;
import java.io.*;

class Main {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a!=0) stack.push(a);
            else stack.pop();
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.print(sum);
    }
}