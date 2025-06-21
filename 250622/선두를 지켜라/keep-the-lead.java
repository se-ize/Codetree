import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        int[][] B = new int[m][2];
        for (int i = 0; i < m; i++) {
            B[i][0] = sc.nextInt();
            B[i][1] = sc.nextInt();
        }
        // Please write your code here.
        int[] raceA = new int[1001];
        int[] raceB = new int[1001]; 
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = idx; j < A[i][1]+idx; j++) {
                raceA[j] = A[i][0];
            }
            idx = A[i][0];
        }
        idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = idx; j < B[i][1]+idx; j++) {
                raceB[j] = B[i][0];
            }
            idx = B[i][0];
        }
        
        char[] winners = new char[1001];
        int answer = 0;
        for (int i = 0; i < 1000; i++) {
            if (raceA[i] > raceB[i]) winners[i] = 'A';
            else if (raceA[i] < raceB[i]) winners[i] = 'B';
            
            if (i > 0 && winners[i] != winners[i-1]) answer++;
        }
        System.out.print(answer);
    }
}