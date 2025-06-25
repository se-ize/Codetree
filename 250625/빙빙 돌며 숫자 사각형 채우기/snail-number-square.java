import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        int[][] answer = new int[101][101];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0;
        int dirNum = 0;
        answer[x][y] = 1; // 초기값

        for (int i = 2; i <= n * n; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];
            // 벽 만나면 시계 방향 회전
            if (!isRange(nx, ny, n) || answer[nx][ny] != 0) {
                dirNum = (dirNum + 1) % 4;
            }
            x = nx;
            y = ny;
            answer[x][y] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isRange(int x, int y, int n) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}