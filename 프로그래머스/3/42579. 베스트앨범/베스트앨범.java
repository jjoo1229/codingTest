import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            int value = 0;
            if (map.containsKey(genres[i])) value = map.get(genres[i]);
            map.put(genres[i], value + plays[i]);
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((a, b) -> map.get(b) - map.get(a));
        
        List<Integer> answerList = new ArrayList<>();

        for (String key : keySet) {
            int maxIdx = -1, secondMaxIdx = -1;
            
            for (int i = 0; i < genres.length; i++) {
                if (key.equals(genres[i])) {
                    if (maxIdx == -1 || plays[i] > plays[maxIdx]
                            || (plays[i] == plays[maxIdx] && i < maxIdx)) {
                        secondMaxIdx = maxIdx;
                        maxIdx = i;

                    } else if (secondMaxIdx == -1 || plays[i] > plays[secondMaxIdx]
                            || (plays[i] == plays[secondMaxIdx] && i < secondMaxIdx)) {
                        secondMaxIdx = i;
                    }
                }
            }
            answerList.add(maxIdx);
            if (secondMaxIdx != -1) answerList.add(secondMaxIdx);
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}