import java.util.*;
import java.io.*;

class Main {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            Integer value = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : null;

            handleStack(line, value);
        }
        System.out.print(sb);
    }

    public static void handleStack(int command, Integer value) {
        switch (command) {
            case 1:
                stack.push(value);
                break;
            case 2:
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
                break;
            case 3:
                sb.append(stack.size()).append('\n');
                break;
            case 4:
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                break;
            case 5:
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
                break;
        }
    }
}