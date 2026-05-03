// MST
import java.util.*;

class Node implements Comparable<Node> {
    int to;
    int weight;
    
    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node node) {
        return weight - node.weight;
    }
}

class Solution {
    public static boolean[] visited;
    public int solution(int n, int[][] costs) {
        visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        ArrayList<Node>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] cost : costs) {
            int s = cost[0];
            int e = cost[1];
            int w = cost[2];
            graph[s].add(new Node(e, w));
            graph[e].add(new Node(s, w));
        }
        
        pq.add(new Node(0, 0));
        
        int sum = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int to = node.to;
            int weight = node.weight;
            
            if (!visited[to]) {
                visited[to] = true;
                sum += weight;
                
                for (Node next : graph[to]) {
                    if (!visited[next.to]) {
                        pq.add(next);
                    }
                }
            }
        }
        
        return sum;
    }
}