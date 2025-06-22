import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][2];
        int[][] b = new int[m][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
        }
        // Please write your code here.
        int[] raceA = new int[1000000];
        int[] raceB = new int[1000000];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[i][1]; j++) {
                if (idx + 1 >= raceA.length) break;
                raceA[idx + 1] = raceA[idx] + a[i][0];
                idx++;
            }
        }
        
        idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < b[i][1]; j++) {
                if (idx + 1 >= raceB.length) break;
                raceB[idx + 1] = raceB[idx] + b[i][0];
                idx++;
            }
        }

        String prevCombo = "";
        int answer = 0;

        for (int i = 1; i < 1000001; i++) {
            if (raceA[i] == 0 && raceB[i] == 0) break;
            String currentCombo;
            
            if (raceA[i] > raceB[i]) currentCombo = "A";
            else if (raceA[i] < raceB[i]) currentCombo = "B";
            else currentCombo = "AB";

            if (!currentCombo.equals(prevCombo)) {
                answer++;
                prevCombo = currentCombo;
            }
        }
        System.out.print(answer);
    }
}