import java.util.*;
public class Main {
    public static int n;
    public static boolean inRange(int i, int j) {
        return (0 <= i && i < n && 0 <= j && j < n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        int[][] grid = new int[n][n];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // 우선순위 : 상 < 하 < 좌 < 우 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        List<Integer> path = new ArrayList<>();
        int x = r, y = c;
        path.add(grid[x][y]);

        while (true) {
            int maxValue = grid[x][y];
            int nextX = -1, nextY = -1; // 초기화 - 유효한 좌표x

            // 상하좌우 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 격자 안인지 먼저 계산해야함
                if (inRange(nx, ny) && grid[nx][ny] > maxValue) {
                    maxValue = grid[nx][ny];
                    nextX = nx;
                    nextY = ny;
                    // 상화좌우 우선순위이므로 처음으로 큰 값을 찾은 방향이 가장 좋은 방향
                    break;
                }
            }

            if (nextX == -1 && nextY == -1) break;
            x = nextX;
            y = nextY;
            path.add(grid[x][y]);
        }

        for (int num : path) {
            System.out.print(num + " ");
        }
    }

}