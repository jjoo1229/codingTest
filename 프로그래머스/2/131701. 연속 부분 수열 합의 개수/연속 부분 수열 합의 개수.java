import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] extended = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            extended[i] = elements[i % n];
        }
        HashSet<Integer> sumSet = new HashSet<>(); // 중복 제거

        for (int len = 1; len <= n; len++) {
            int sum = 0;
            // 처음 윈도우 합 초기화
            for (int i = 0; i < len; i++) {
                sum += extended[i];
            }
            sumSet.add(sum);
            // 슬라이딩 윈도우로 다음 부분합 계산
            for (int i = 1; i < n; i++) {
                sum = sum - extended[i - 1] + extended[i + len - 1];
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}