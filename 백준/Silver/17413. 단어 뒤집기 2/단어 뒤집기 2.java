import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Character> deque = new ArrayDeque<>();
        boolean isTag = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '<') {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast());
                }
                isTag = true;
                sb.append(c);
            }
            else if (c == '>') {
                isTag = false;
                sb.append(c);
            }
            else if (isTag) {
                sb.append(c);
            }
            else {
                if (c == ' ') {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                    }
                    sb.append(' ');
                } else {
                    deque.addLast(c);
                }
            }
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }

        System.out.println(sb.toString());
    }
}