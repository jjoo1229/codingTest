import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            sb.append(isVPS(line)).append('\n');
        }
        System.out.print(sb);
    }

    public static String isVPS(String line) {
        Stack<Character> stack = new Stack<>();
        
        for (int j = 0; j < line.length(); j++) {
            char c = line.charAt(j);

            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}