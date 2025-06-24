import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N * N
        int T = sc.nextInt(); // T초가 지난 후 해당 구슬의 위치
        // 초기에 놓인 구슬 - R행 C열
        int R = sc.nextInt();         
        int C = sc.nextInt(); 
        char D = sc.next().charAt(0); // U, D, R, L 중 하나
        // Please write your code here.
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int dirNum = getDir(D); // 초기 방향
        int x = R - 1; //인덱스에 맞게 보정
        int y = C - 1;

        while (T > 0) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];
            // 벽에 부딪히면 방향 반전하고 1초 소요
            if (!inRange(nx, ny, N)) {
                dirNum = reverseDir(dirNum);
                T--; //위 치는 안바뀜
            } else { // 정상 이동
                x = nx;
                y = ny;
                T--;
            }
        }
        System.out.print((x+1) + " " + (y+1));
        // 출력시 괄호 필수!!
    }
    public static boolean inRange(int x, int y, int N) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
    public static int getDir(char a) {
        switch (a) {
            case 'U': return 0;
            case 'D': return 1;
            case 'R': return 2;
            case 'L': return 3;
            default: return -1;
        }
    }
    public static int reverseDir(int dir) {
        switch (dir) {
            case 0: return 1; // U -> D
            case 1: return 0; // D -> U
            case 2: return 3; // R -> L
            case 3: return 2; // L -> R
            default: return -1;
        }
    }
}