import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt();
        int rect1_y1 = sc.nextInt();
        int rect1_x2 = sc.nextInt();
        int rect1_y2 = sc.nextInt();
        int rect2_x1 = sc.nextInt();
        int rect2_y1 = sc.nextInt();
        int rect2_x2 = sc.nextInt();
        int rect2_y2 = sc.nextInt();
        int offset = 1000;
        int[][] area = new int[2000][2000];

        for (int i = rect1_x1; i < rect1_x2; i++) {
            for (int j = rect1_y1; j < rect1_y2; j++) {
                area[i+offset][j+offset] = 1;
            }
        }

        // 값이 1이라면 2로 설정 -> 1로 설정된 부분 최소/최대 행, 열 좌표 구하기
        for (int i = rect2_x1; i < rect2_x2; i++) {
            for (int j = rect2_y1; j < rect2_y2; j++) {
                if (area[i+offset][j+offset] == 1) {
                    area[i+offset][j+offset] = 2;
                }
            }
        }

        int x1 = 2000, y1 = 2000; //최소 행,열
        int x2 = 0, y2 = 0; //최대 행,열
        boolean hasRemains = false;
        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j < 2000; j++) {
                if (area[i][j] == 1) {
                    hasRemains = true;
                    x1 = Math.min(x1, i);
                    x2 = Math.max(x2, i);
                    y1 = Math.min(y1, j);
                    y2 = Math.max(y2, j);
                }
            }
        }
        if (hasRemains) {
            System.out.print(((x2+1)-x1)*((y2+1)-y1));
        } else System.out.print(0);
    }
}