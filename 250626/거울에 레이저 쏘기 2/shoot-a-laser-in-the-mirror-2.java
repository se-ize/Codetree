import java.util.Scanner;

public class Main {
    static int n;
    static char[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int k = sc.nextInt();
        simulate(k);
    }

    static void simulate(int k) {
        int x = 0, y = 0, dir = 0;

        // 방향: 오른(0), 아래(1), 왼(2), 위(3)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 시작 위치 및 방향 설정
        if (k <= n) { // 위에서 아래로 진입
            x = 0;
            y = k - 1;
            dir = 1;
        } else if (k <= 2 * n) { // 오른쪽에서 왼쪽으로
            x = k - n - 1;
            y = n - 1;
            dir = 2;
        } else if (k <= 3 * n) { // 아래에서 위로
            x = n - 1;
            y = 3 * n - k;
            dir = 3;
        } else { // 왼쪽에서 오른쪽으로
            x = 4 * n - k;
            y = 0;
            dir = 0;
        }

        int count = 0;
        while (x >= 0 && x < n && y >= 0 && y < n) {
            char mirror = grid[x][y];
            // 반사 규칙
            if (mirror == '/') {
                if (dir == 0) dir = 3;
                else if (dir == 1) dir = 2;
                else if (dir == 2) dir = 1;
                else if (dir == 3) dir = 0;
            } else if (mirror == '\\') {
                if (dir == 0) dir = 1;
                else if (dir == 1) dir = 0;
                else if (dir == 2) dir = 3;
                else if (dir == 3) dir = 2;
            }
            count++;
            x += dx[dir];
            y += dy[dir];
        }

        System.out.println(count);
    }
}
