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
        int[] raceA = new int[10001];
        int[] raceB = new int[10001]; 
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < A[i][1]; j++) {
                if (idx + 1 >= raceA.length) break;
                raceA[idx + 1] = raceA[idx] + A[i][0]; //누적 거리 저장
                idx++;
            }
        }

        idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < B[i][1]; j++) {
                if (idx + 1 >= raceB.length) break;
                raceB[idx + 1] = raceB[idx] + B[i][0];
                idx++;
            }
        }
        
        char prev = 'T'; // 이전 선두
        char current = 'T';
        int answer = 0;
        
        for (int i = 1; i < 1001; i++) {
            if (raceA[i] == 0 && raceB[i] == 0) break; // 둘 다 경주 끝났으면 종료

            if (raceA[i] > raceB[i]) current = 'A';
            else if (raceA[i] < raceB[i]) current = 'B';
            else current = 'T'; // 동점인 경우

            if (current == 'T') continue;

             // 이전 선두가 A나 B일 때만 선두 변경 체크
             if (prev != 'T' && current != prev) answer++;
             // 선두 갱신
             prev = current;
        }
        System.out.print(answer);
    }
}