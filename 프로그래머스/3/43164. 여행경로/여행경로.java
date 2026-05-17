import java.util.*;

class Solution {
    public static Map<String, ArrayList<String>> graph;
    public static ArrayList<String> answer;
    public static int n;
    
    public String[] solution(String[][] tickets) {
        answer= new ArrayList<>();
        graph = new HashMap<>();
        n = tickets.length;
        
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String arrive = ticket[1];
            graph.computeIfAbsent(start, k -> new ArrayList<>()).add(arrive);
        }
        
        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key));  // 알파벳순 정렬
        }
        
        answer.add("ICN");
        dfs("ICN");
        return answer.toArray(new String[answer.size()]);
    }
    
    public static boolean dfs(String node) {
        if (answer.size() == n + 1) return true;
        if (!graph.containsKey(node)) return false;
        
        List<String> list = graph.get(node);
        for (int i = 0; i < list.size(); i++) {
            String next = list.remove(i);
            answer.add(next);
            
            if (dfs(next)) return true;
            
            answer.remove(answer.size() - 1);
            list.add(i, next);
        }
        
        return false;
    }
}