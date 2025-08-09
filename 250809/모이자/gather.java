import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1]; // 1-based index

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        // Please write your code here.
        int minDist = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) { // i번 집으로 모인다고 가정
            int dist = 0;
            for (int j = 1; j <= n; j++) {
                dist += Math.abs(i - j) * a[j];
            }
            if (minDist > dist) minDist = dist;
        }
        System.out.println(minDist);
    }
}