import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int offset = 100;
        int[][] area = new int[200][200];
        for (int i = 1; i < n + 1; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    if (i % 2 == 1) {
                        area[j+offset][k+offset] = 1;
                    } else {
                        area[j+offset][k+offset] = 2;
                    }
                }
            }
        }
        int blue = 0;
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                if (area[i][j] == 2) blue++;
            }
        }
        System.out.print(blue);
    }
}