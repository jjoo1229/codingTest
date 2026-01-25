import java.util.*;
import java.io.*;

class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int last;  // 마지막 push 값 저장
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            if (line.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                queue.offer(value);
                last = value;
            } else {
                handleQueue(line);
            }
        }
        System.out.print(sb);
    }

    public static void handleQueue(String command) {
        switch (command) {
            case "pop":
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                break;
            case "size":
                sb.append(queue.size()).append('\n');
                break;
            case "empty":
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                break;
            case "front":
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                break;
            case "back":
                sb.append(queue.isEmpty() ? -1 : last).append('\n');
                break;
        }
    }
}