class Solution {
    public int solution(int n) {
        int count = countOne(Integer.toBinaryString(n));
        int answer = n + 1;
        
        while (true) {
            if (countOne(Integer.toBinaryString(answer)) == count){
                return answer;
            }
            answer++;
        }
    }
    
    public int countOne(String str) {
        int count = 0;
        for (char s: str.toCharArray()) {
            if (s == '1') {  // char 비교는 == 사용
                count++;
            }
        }
        return count;
    }
}