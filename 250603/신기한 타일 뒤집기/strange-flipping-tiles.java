import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int MAX_K = 100000;
        int idx = MAX_K;
        char[] lines = new char[2 * MAX_K + 1];
        int white = 0, black = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            if (d == 'L') {
                for (int j = idx; j > idx - x; j--) {
                    lines[j] = 'W';
                }
                idx -= (x - 1);
            } else {
                for (int j = idx; j < idx + x; j++) {
                    lines[j] = 'B';
                }
                idx += (x - 1);
            }
        }
        
        for (int i = 0; i < 2 * MAX_K; i++) {
            if (lines[i] == 'W') white++;
            else if (lines[i] == 'B') black++;
        }
        System.out.print(white + " " + black);
    }
}