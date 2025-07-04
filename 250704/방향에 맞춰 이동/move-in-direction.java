import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0, y = 0;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            // Please write your code here.
            if (direction == 'E') {
                x += distance * dx[0];
                y += distance * dy[0];
            } else if (direction == 'S') {
                x += distance * dx[1];
                y += distance * dy[1];
            } else if (direction == 'W') {
                x += distance * dx[2];
                y += distance * dy[2];
            } else {
                x += distance * dx[3];
                y += distance * dy[3];
            }
        }
        System.out.print(x + " " + y);
    }
}