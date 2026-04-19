class Solution {
    public static int n, answer;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        answer = 0;
        dfs(0, numbers, 0, target);
        return answer;
    }
    
    public void dfs(int index, int[] numbers, int result, int target) {
        if (index == n) {
            if (result == target) answer++;
            return;
        }
        dfs(index + 1, numbers, result + numbers[index], target);
        dfs(index + 1, numbers, result - numbers[index], target);
    }
}