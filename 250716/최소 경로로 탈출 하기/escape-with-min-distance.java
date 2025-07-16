import java.util.*;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, m;
    public static int[][] a = new int[100][100];
    public static int[][] step = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
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

            int[] dx = new int[]{0, 0, -1, 1};
            int[] dy = new int[]{-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (inRange(newX, newY) && a[newX][newY] == 1 && !visited[newX][newY])
                    push(newX, newY, step[x][y] + 1); 
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        // Please write your code here.

        push(0, 0, 0);
        BFS();

        System.out.println(visited[n-1][m-1] ? step[n-1][m-1] : -1);
    }
}