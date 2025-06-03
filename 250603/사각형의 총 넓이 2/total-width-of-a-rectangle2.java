import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        int offset = 100;
        int answer = 0;
        boolean[][] area = new boolean[200][200];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();
            for (int k = x1[i]; k < x2[i]; k++) {
                for (int j = y1[i]; j < y2[i]; j++) {
                    area[k][j] = true;
                }
            }
        }

        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                if (area[i][j] == true) answer++;
            }
        }
        System.out.print(answer);
    }
}