import java.util.*;

public class Letter {
    String letter;
    int step;
    
    public Letter(String letter, int step) {
        this.letter = letter;
        this.step = step;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;
            
        int n = words.length;
        
        boolean[] visited = new boolean[n];
        Queue<Letter> q = new ArrayDeque<>();
        q.add(new Letter(begin, 0));
        
        while (!q.isEmpty()) {
            Letter cur = q.poll();
            
            if (cur.letter.equals(target)) return cur.step;
            
            for (int i = 0; i < n; i++) {
                if (!visited[i] && oneLetterDiff(cur.letter, words[i])) {
                    visited[i] = true;
                    q.add(new Letter(words[i], cur.step + 1));
                }
            }
        }
        return 0;
    }
    
    public boolean oneLetterDiff(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return true;
    }
}