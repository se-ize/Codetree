import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int[] x1 = new int[n];
        // int[] x2 = new int[n];
        int[] lines = new int[200];
        int offset = 100;
        for (int i = 0; i < n; i++) {
            // x1[i] = sc.nextInt();
            // x2[i] = sc.nextInt();
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            for (int j = x1+offset; j <= x2-1+offset; j++) {
                lines[j]++;
            }
        }

        Arrays.sort(lines);
        System.out.print(lines[199]);
        // Please write your code here.

    }
}