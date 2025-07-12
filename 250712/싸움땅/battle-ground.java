import java.util.*;
import java.io.*;
public class Main {
    static int n, m, k;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer>[][] guns;
    static ArrayList<Player> players;

    static class Player {
        int id, x, y, d, s, a, point;

        public Player(int id, int x, int y, int d, int s) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
            this.a = 0;
            this.point = 0;
        }
        public int getTotalAttack() {
            return this.s + this.a;
        }
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        guns = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                guns[i][j] = new ArrayList<>();
                int power = sc.nextInt();
                if (power > 0) guns[i][j].add(power);
            }
        }

        players = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1; //0-based index
            int y = sc.nextInt() - 1;
            int d = sc.nextInt();
            int s = sc.nextInt();
            players.add(new Player(i, x, y, d, s));
        }

        for (int round = 0; round < k; round++) {
            for (Player currentPlayer : players) {
                movePlayer(currentPlayer);

                Player opponent = null;
                for (Player p : players) {
                    if (p.id != currentPlayer.id && p.x == currentPlayer.x
                        && p.y == currentPlayer.y) {
                        opponent = p;
                        break;
                    }
                }

                if (opponent != null) {
                    fight(currentPlayer, opponent);
                } else {
                    changeGun(currentPlayer);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Player p : players) {
            sb.append(p.point).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static boolean inRange(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    private static void movePlayer(Player p) {
        int nx = p.x + dx[p.d];
        int ny = p.y + dy[p.d];

        if (!inRange(nx, ny, n)) {
            p.d = (p.d + 2) % 4;
            nx = p.x + dx[p.d];
            ny = p.y + dy[p.d];
        }
        p.x = nx;
        p.y = ny;
    }

    private static void fight(Player p1, Player p2) {
        Player winner, loser;

        if (p1.getTotalAttack() > p2.getTotalAttack() ||
            (p1.getTotalAttack() == p2.getTotalAttack() && p1.s > p2.s)) {
                winner = p1;
                loser = p2;
            } else {
                winner = p2;
                loser = p1;
            }

            winner.point += winner.getTotalAttack() - loser.getTotalAttack();
            moveLoser(loser);
            changeGun(winner);
    }

    private static void moveLoser(Player loser) {
        if (loser.a > 0) {
            guns[loser.x][loser.y].add(loser.a);
            loser.a = 0;
        }

        for (int i = 0; i < 4; i++) {
            int next_d = (loser.d + i) % 4;
            int nx = loser.x + dx[next_d];
            int ny = loser.y + dy[next_d];

            boolean playerExists = false;
            for (Player p : players) {
                if (p.id != loser.id && p.x == nx && p.y == ny) {
                    playerExists = true;
                    break;
                }
            }

            if (inRange(nx, ny, n) && !playerExists) {
                loser.d = next_d;
                loser.x = nx;
                loser.y = ny;
                break;
            }
        }
        changeGun(loser);
    }

    private static void changeGun(Player p) {
        if (guns[p.x][p.y].isEmpty()) return;

        int maxGunPower = Collections.max(guns[p.x][p.y]);

        if (maxGunPower > p.a) {
            if (p.a > 0) guns[p.x][p.y].add(p.a);
            p.a = maxGunPower;
            guns[p.x][p.y].remove(Integer.valueOf(maxGunPower));
        }
    }
}