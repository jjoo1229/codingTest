import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        Map<Integer, Character> info = new HashMap<>();
        
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            map[row - 1][col - 1] = 1;
        }
        
        int l = sc.nextInt();
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.put(x, c);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0;
        int seconds = 0;
        Queue<int[]> snake = new LinkedList<>();
        int headX = 0, headY = 0;
        snake.offer(new int[]{headX, headY});

        while (true) {
            headX += dx[dir];
            headY += dy[dir];
            seconds++;
            
            if (!canGo(snake, headX, headY, n)) break;
            if (map[headX][headY] == 1) {  // 꼬리 그대로
                map[headX][headY] = 0;
            } else if (map[headX][headY] == 0) {  // 꼬리 하나 줄음
                snake.poll();
            }
            snake.offer(new int[]{headX, headY});  // 머리 연장

            if (info.containsKey(seconds)) {
                if (info.get(seconds) == 'D') dir = (dir + 1) % 4;
                else if (info.get(seconds) == 'L') dir = (dir + 3) % 4;
            }
        }
        System.out.print(seconds);
	}

    static boolean canGo(Queue<int[]> q, int x, int y, int n) {
        if (x < 0 || x >= n || y < 0 || y >= n) return false;
        for (int[] arr : q) {
            if (arr[0] == x && arr[1] == y) return false;
        }
        return true;
    }
}