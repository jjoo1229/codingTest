import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 귤 크기별 개수 세기
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        // 개수만 리스트로 추출
        List<Integer> counts = new ArrayList<>(countMap.values());

        // 내림차순 정렬
        counts.sort(Collections.reverseOrder());

        int total = 0;
        int kinds = 0;

        for (int cnt : counts) {
            total += cnt;
            kinds++;

            if (total >= k) {
                break;
            }
        }

        return kinds;
    }
}