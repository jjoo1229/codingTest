import java.util.*;
import java.io.*;

class Main {
    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            Integer value = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : null;

            handleDeque(line, value);
        }
        System.out.print(sb);
    }

    public static void handleDeque(int command, Integer value) {
        switch (command) {
            case 1:
                deque.addFirst(value);
                break;
            case 2:
                deque.addLast(value);
                break;
            case 3:
                sb.append(deque.isEmpty() ? -1 : deque.removeFirst()).append('\n');
                break;
            case 4:
                sb.append(deque.isEmpty() ? -1 : deque.removeLast()).append('\n');
                break;
            case 5:
                sb.append(deque.size()).append('\n');
                break;
            case 6:
                sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                break;
            case 7:
                sb.append(deque.isEmpty() ? -1 : deque.getFirst()).append('\n');
                break;
            case 8:
                sb.append(deque.isEmpty() ? -1 : deque.getLast()).append('\n');
                break;
        }
    }
}