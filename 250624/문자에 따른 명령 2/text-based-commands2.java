import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // Please write your code here.
        int x = 0, y = 0;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        int dirNum = 3; // 북쪽

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                // 반시계 회전
                dirNum = (dirNum + 3) % 4;
            } else if (c == 'R') {
                // 시계 회전
                dirNum = (dirNum + 1) % 4;
            } else {
                // 바라보고 있는 방향으로 한 칸 이동
                x += dx[dirNum];
                y += dy[dirNum];   
            }
        }
        System.out.print(x + " " + y);
    }
}