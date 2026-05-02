// 최소 이동 횟수랑 알파벳 차를 따로 구해주기
class Solution {
    public int solution(String name) {
        int n = name.length();
        int alphabet = 0;
        int minMove = n - 1;
        
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            alphabet += Math.min(c - 'A', 'Z' - c + 1);
        
            int next = i + 1;  // 커서 이동
            while (next < n && name.charAt(next) == 'A') next++; // A를 건너가는 경우 계산
            
            minMove = Math.min(minMove, i + n - next + Math.min(i, n - next));
        }
        
        return alphabet + minMove;
    }
}