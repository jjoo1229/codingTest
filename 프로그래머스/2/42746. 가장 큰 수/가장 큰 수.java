import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        Integer[] arr = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) arr[i] = numbers[i];
        
        Arrays.sort(arr, (a,b) -> {
            String s1 = a.toString() + b.toString();
            String s2 = b.toString() + a.toString();
            return s2.compareTo(s1);
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) sb.append(arr[i]);
        if (sb.toString().startsWith("0")) return "0";
        return sb.toString();
    }
}