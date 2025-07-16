import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, h, m;
    public static int a[][] = new int[100][100];
    public static int step[][] = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void push(int x, int y, int s) {
        step[x][y] = s;
        visited[x][y] = true;
        q.add(new Pair(x, y));
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;

            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (inRange(newX, newY) && a[newX][newY] != 1 && !visited[newX][newY])
                    push(newX, newY, step[x][y] + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        // 사람마다 가장 가까운 비 피할 공간까지의 거리를 구해야함
        // -> 비 피할 공간들을 BFS의 시작점으로
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] == 3)
                    push(i, j, 0);
        BFS();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 2) {
                    if (visited[i][j]) {
                        System.out.print(step[i][j] + " ");
                    } else {
                        System.out.print(-1 + " ");
                    }
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
}