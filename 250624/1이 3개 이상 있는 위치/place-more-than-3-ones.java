import java.util.*;

public class Main {
    public static boolean inRange(int x, int y, int N) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int dirNum = 0; dirNum < 4; dirNum++) {
                    int nx = i + dx[dirNum];
                    int ny = j + dy[dirNum];
                    if (inRange(nx, ny, N) && array[nx][ny] == 1) cnt++;
                }
                if (cnt >= 3) answer++;
            }
        }
        System.out.print(answer);
    }
}