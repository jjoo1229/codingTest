class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String a : arr) {
            int num = Integer.parseInt(a);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min + " " + max;
    }
}