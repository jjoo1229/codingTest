import java.util.*;

class Solution {
    public static String[] vowels = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        ArrayList<String> dict = new ArrayList<>();
        
        for (String a : vowels) {
            dict.add(a);
            for (String b : vowels) {
                dict.add(a + b);
                for (String c : vowels) {
                    dict.add(a + b + c);
                    for (String d : vowels) {
                        dict.add(a + b + c + d);
                        for (String e : vowels) {
                            dict.add(a + b + c + d + e);
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < dict.size(); i++) {
            String line = dict.get(i);
            if (line.equals(word)) return i + 1;
        }
        
        return -1;
    }
}