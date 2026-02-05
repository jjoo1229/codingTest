import java.util.*;
 
class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int r = sc.nextInt();
        int num = sc.nextInt();
        if (num > c * r) {
            System.out.print(0);
            System.exit(0);
        }
        int[][] arr = new int[r][c];
        int[][] visited = new int[r][c];

        int[] dx = {-1, 0, 1, 0};  // 시계 방향
        int[] dy = {0, 1, 0, -1};
        int dir = 0;

        int x = r - 1, y = 0;
        visited[x][y] = 1;
        for (int i = 1; i < num; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] == 1) {
                dir = (dir + 1) % 4;
                i--;
            } else {
                visited[nx][ny] = 1;
                x = nx;
                y = ny;
            }
        }
        System.out.printf("%d %d", y + 1, r - x);
    }
}