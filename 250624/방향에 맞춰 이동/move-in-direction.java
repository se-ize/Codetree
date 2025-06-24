import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0, y = 0;
        int nx = 0, ny = 0;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            // Please write your code here.
            if (direction == 'E') {
                nx += x + distance * dx[0];
                ny += y + distance * dy[0];
            } else if (direction == 'S') {
                nx += x + distance * dx[1];
                ny += y + distance * dy[1];
            } else if (direction == 'W') {
                nx += x + distance * dx[2];
                ny += y + distance * dy[2];
            } else {
                nx += x + distance * dx[3];
                ny += y + distance * dy[3];
            }
        }
        System.out.print(nx + " " + ny);
    }
}