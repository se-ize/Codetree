import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, k;
    public static int[][] a = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && a[x][y] == 0 && !visited[x][y];
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;

            int[] dx = new int[]{0, 0, -1, 1};
            int[] dy = new int[]{-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    q.add(new Pair(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        int[][] starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt() - 1; // 0-based index
            starts[i][1] = sc.nextInt() - 1;

            q.add(new Pair(starts[i][0], starts[i][1]));
            visited[starts[i][0]][starts[i][1]] = true;
        }
        // Please write your code here.
        BFS();
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (visited[i][j]) count++;
        System.out.println(count);
    }
}