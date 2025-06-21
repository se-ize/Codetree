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
            for (int j = 0; j < A[i][1]; j++) {
                raceA[idx + 1] = raceA[idx] + A[i][0]; //누적 거리 저장
                idx++;
            }
        }

        idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < B[i][1]; j++) {
                raceB[idx + 1] = raceB[idx] + B[i][0];
                idx++;
            }
        }
        
        char[] winners = new char[1001];
        char prev = 'T'; //초기값
        int answer = 0;
        
        for (int i = 1; i < 1001; i++) {
            if (raceA[i] == 0 && raceB[i] == 0) break; // 둘 다 경주 끝났으면 종료

            if (raceA[i] > raceB[i]) winners[i] = 'A';
            else if (raceA[i] < raceB[i]) winners[i] = 'B';
            else winners[i] = 'T';

            if (winners[i] == 'T') continue; // 동점이면 prev 유지 (선두 유지 중)
    
            // 선두가 바뀐 경우에만 체크
            if (winners[i] != prev) {
                answer++;
                prev = winners[i];
            }
        }
        System.out.print(answer);
    }
}