import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int offset = 100;
        boolean[][] area = new boolean[200][200];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            for (int j = x[i]; j < x[i]+8; j++) {
                for (int k = y[i]; k < y[i]+8; k++) {
                    area[j+offset][k+offset] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                if (area[i][j] == true) answer++;
            }
        }
        System.out.print(answer);
    }
}