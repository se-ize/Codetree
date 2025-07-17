import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        int[][] array = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            array[x][y] = 1;
            int count = 0;

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (inRange(nx, ny, n)) {
                    if (array[nx][ny] == 1) count++;
                }
            }
            System.out.println(count == 3 ? 1 : 0);
        }
    }
    public static boolean inRange(int x, int y, int n) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}