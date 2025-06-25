import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();
        // Please write your code here.
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0;
        int dir = 3;
        int time = 0;
        boolean isReturned = false;

        for (int i = 0; i < commands.length(); i++) {
            char c = commands.charAt(i);
            if (c == 'L') {
                dir = (dir + 3) % 4;
                time++;
            } else if (c == 'R') {
                dir = (dir + 1) % 4;
                time++;
            } else {
                x += dx[dir];
                y += dy[dir];
                time++;
            }
            if (x == 0 && y == 0) {
                isReturned = true;
                break;
            }
        }
        System.out.print(isReturned ? time : -1);
    }
}