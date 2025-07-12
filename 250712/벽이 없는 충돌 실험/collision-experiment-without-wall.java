import java.util.*;

class Marble {
    int x, y, weight, dir, num;
    public Marble(int x, int y, int weight, int dir, int num) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.dir = dir;
        this.num = num;
    }
}

public class Main {
    public static final int BLANK = -1;
    public static final int COORD_SIZE = 4000;
    public static final int OFFSET = 2000;

    public static int t, n;
    
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static int currTime;
    public static int lastCollisionTime;

    public static ArrayList<Marble> marbles = new ArrayList<>();
    public static ArrayList<Marble> nextMarbles = new ArrayList<>();
    public static int[][] nextMarbleIndex = new int[COORD_SIZE + 1][COORD_SIZE + 1];

    public static Marble Move(Marble marble) {
        int x = marble.x;
        int y = marble.y;
        int weight = marble.weight;
        int dir = marble.dir;
        int num = marble.num;

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        return new Marble(nx, ny, weight, dir, num);
    }

    public static int findDuplicateMarble(Marble marble) {
        int targetX = marble.x;
        int targetY = marble.y;

        return nextMarbleIndex[targetX][targetY];
    }

    public static Marble Collide(Marble marble1, Marble marble2) {
        int weight1 = marble1.weight;
        int num1 = marble1.num;

        int weight2 = marble2.weight;
        int num2 = marble2.num;

        if (weight1 > weight2 || (weight1 == weight2 && num1 > num2)) {
            return marble1;
        } else {
            return marble2;
        }
    }

    public static boolean inRange(Marble marble) {
        int x = marble.x;
        int y = marble.y;

        return (0 <= x && x <= COORD_SIZE) && (0 <= y && y <= COORD_SIZE);
    }

    public static void pushNextMarble(Marble marble) {
        if (!inRange(marble)) return;
        int index = findDuplicateMarble(marble);

        if (index == BLANK) {
            nextMarbles.add(marble);

            int x = marble.x;
            int y = marble.y;
            nextMarbleIndex[x][y] = (int)(nextMarbles.size()) - 1;
        } else {
            Marble newMarble = Collide(nextMarbles.get(index), marble);
            nextMarbles.set(index, newMarble);
            lastCollisionTime = currTime;
        }
    }

    public static void simulate() {
        for (int i = 0; i < (int) marbles.size(); i++) {
            Marble nextMarble = Move(marbles.get(i));
            pushNextMarble(nextMarble);
        }

        marbles = (ArrayList<Marble>) nextMarbles.clone();

        for (int i = 0; i < (int) nextMarbles.size(); i++) {
            int x = nextMarbles.get(i).x;
            int y = nextMarbles.get(i).y;
            nextMarbleIndex[x][y] = BLANK;
        }
        nextMarbles = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int i = 0; i <= COORD_SIZE; i++) {
            for (int j = 0; j <= COORD_SIZE; j++) {
                nextMarbleIndex[i][j] = BLANK;
            }
        }

        for (int tc = 0; tc < t; tc++) {
            marbles = new ArrayList<>();
            lastCollisionTime = -1;

            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int w = sc.nextInt();
                char d = sc.next().charAt(0);
                // (x, y) 에서 w 무게를 갖고 d 방향으로 이동중

                x *= 2; y *= 2;
                x += OFFSET; y += OFFSET;
                marbles.add(new Marble(x, y, w, direction(d), i));
            }

            for (int i = 1; i <= COORD_SIZE; i++) {
                currTime = i;
                simulate();
            }
            // Please write your code here.
            System.out.println(lastCollisionTime);
        }
    }
    public static int direction(char dir) {
        switch(dir) {
            case 'U': return 0;
            case 'D': return 1;
            case 'R': return 2;
            case 'L': return 3;
            default: return -1;
        }
    }
}