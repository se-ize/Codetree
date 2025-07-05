import java.util.*;
public class Main {
    static int n, m, h, k;
    static ArrayList<Integer>[][] hiders;
    static ArrayList<Integer>[][] nextHiders;
    static boolean[][] tree;
    static int seekerX, seekerY, seekerDir;
    static int score;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    public static void hiderMove(int x, int y, int moveDir) {
        if (Math.abs(seekerX - x) + Math.abs(seekerY - y) > 3) {
            nextHiders[x][y].add(moveDir);
            return;
        }

        int nx = x + dx[moveDir];
        int ny = y + dy[moveDir];
        if (!inRange(nx, ny)) {
            moveDir = (moveDir + 2) % 4;
            nx = x + dx[moveDir];
            ny = y + dy[moveDir];
        }

        if (nx == seekerX && ny == seekerY) {
            nextHiders[x][y].add(moveDir);
        } else {
            nextHiders[nx][ny].add(moveDir);
        }
    }

    public static void hiderMoves() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextHiders[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int hiderDir : hiders[i][j]) {
                    hiderMove(i, j, hiderDir);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hiders[i][j] = nextHiders[i][j];
            }
        }
    }

    public static void seekerMove() {
        seekerX += dx[seekerDir];
        seekerY += dy[seekerDir];

        if (seekerX - seekerY == -1 && seekerX < n / 2) {
            if (seekerDir == 0) {
                seekerDir = 1;
            } else if (seekerDir == 3) {
                seekerDir = 2;
            }
        } else if (seekerX + seekerY == n - 1 && seekerX < n / 2) {
            if (seekerDir == 1) {
                seekerDir = 2;
            } else if (seekerDir == 0) {
                seekerDir = 3;
            }
        } else if (seekerX - seekerY == 0 && seekerX > n / 2) {
            if (seekerDir == 2) {
                seekerDir = 3;
            } else if (seekerDir == 1) {
                seekerDir = 0;
            }
        } else if (seekerX + seekerY == n - 1 && seekerX > n / 2) {
            if (seekerDir == 3) {
                seekerDir = 0;
            } else if (seekerDir == 2) {
                seekerDir = 1;
            }
        }

        if (seekerX == 0 && seekerY == 0 && seekerDir == 0) {
            seekerDir = 2;
        } else if (seekerX == n / 2 && seekerY == n / 2 && seekerDir == 2) {
            seekerDir = 0;
        }
    }

    public static void catchHiders(int t) {
        for (int dist = 0; dist < 3; dist++) {
            int nx = seekerX + dist * dx[seekerDir];
            int ny = seekerY + dist * dy[seekerDir];

            if (!inRange(nx, ny) || tree[nx][ny]) continue;

            int caughtCount = hiders[nx][ny].size();
            if (caughtCount > 0) {
                score += t * caughtCount;
                hiders[nx][ny].clear();
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        k = sc.nextInt();

        hiders = new ArrayList[n][n];
        nextHiders = new ArrayList[n][n];
        tree = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hiders[i][j] = new ArrayList<>();
                nextHiders[i][j] = new ArrayList<>();
            }
        }


        int dir = 0;

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            hiders[x-1][y-1].add(d); // 0 based index
        }

        for (int i = 0; i < h; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            tree[x-1][y-1] = true;
        }

        seekerX = n / 2;
        seekerY = n / 2;
        seekerDir = 0;
        score = 0;

        for (int t = 1; t <= k; t++) {
            // 1. 도망자 이동
            hiderMoves();
            // 2. 술래 이동
            seekerMove();
            // 3. 도망자 잡기 및 점수 계산
            catchHiders(t);
        }

        System.out.println(score);
    }
}