import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int idx = 50000;
        int[] A = new int[50000*2];
        int[] B = new int[50000*2];
    
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
            if (d == 'L') {
                for (int j = idx; j > idx-t; j--) {
                    A[j] = -1;
                }
                idx -= (t - 1);                
            } else {
                for (int j = idx; j < idx+t; j++) {
                    A[j] = 1;
                }
                idx += (t + 1);
            }
        }

        idx = 50000;
        
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
            if (d == 'L') {
                for (int j = idx; j > idx-t; j--) {
                    B[j] = -1;
                }
                idx -= (t - 1);                
            } else {
                for (int j = idx; j < idx+t; j++) {
                    B[j] = 1;
                }
                idx += (t + 1);
            }
        }
        
        // Please write your code here.
        int answer = 0;
        for (int i = 0; i < 50000*2; i++) {
            if (A[i] * B[i] == -1) answer++;
        }
        System.out.print(answer);
    }
}