import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
    		int n = sc.nextInt();
    		int[][] graph = new int[n][n];
    		for (int i = 0; i < n; i++) {
        		for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }
            
            Map<Integer, List<Integer>> room = new HashMap<>();
            int max = 0;
            for (int i = 0; i < n; i++) {
        		for (int j = 0; j < n; j++) {
                    int count = move(i, j, n, graph);
                    if (count >= max) {
                        max = count;
                        if (room.containsKey(count)) room.get(count).add(graph[i][j]);
                        else {
                            List<Integer> list = new ArrayList<>();
                            list.add(graph[i][j]);
                            room.put(count, list);
                        }
                    }
                }
            }
            int maxCount = Collections.max(room.keySet());
            int value = Collections.min(room.get(maxCount));
            System.out.printf("#%d %d %d%n", test_case, value, max);
		}
	}

    public static int move(int x, int y, int n, int[][] graph) {
        Queue<int[]> q = new LinkedList<>();
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int count = 1;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (graph[nx][ny] == graph[curX][curY] + 1) {
                    q.offer(new int[]{nx, ny});
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}