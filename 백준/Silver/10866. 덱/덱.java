import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
			String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            
            String cmd = st.nextToken();
            if (st.hasMoreTokens()) {
                if (cmd.equals("push_front"))
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                else if (cmd.equals("push_back"))
                    deque.offerLast(Integer.parseInt(st.nextToken()));
            } else {
                switch(cmd) {
                    case "pop_front":
                        int pf = deque.isEmpty() ? -1 : deque.pollFirst();
                        sb.append(pf).append("\n");
                        break;
                    case "pop_back":
                        int pb = deque.isEmpty() ? -1 : deque.pollLast();
                        sb.append(pb).append("\n");
                        break;
                    case "size":
                        sb.append(deque.size()).append("\n");
                        break;
                    case "empty":
                        int e = deque.isEmpty() ? 1 : 0;
                        sb.append(e).append("\n");
                        break;
                    case "front":
                        int f = deque.isEmpty() ? -1 : deque.peekFirst();
                        sb.append(f).append("\n");
                        break;
                    case "back":
                        int b = deque.isEmpty() ? -1 : deque.peekLast();
                        sb.append(b).append("\n");
                        break;
                    default: break;
                }
            }
        }
        System.out.print(sb.toString());
    }
}