import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] lines = new char[1000000];
        int[] whites = new int[1000000];
        int[] blacks = new int[1000000];
        int idx = 1000000/2;
        int white = 0, black = 0, gray = 0;
        
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            if (d == 'R') {
                for (int j = idx; j < idx + x; j++) {
                    if (lines[j] == 'G') continue;
                    blacks[j]++;

                    if (whites[j] >= 2 && blacks[j] >= 2) {
                        lines[j] = 'G';
                    } else lines[j] = 'B';
                }
                idx += (x - 1);
            } else {
                for (int j = idx; j > idx - x; j--) {
                    if (lines[j] == 'G') continue;
                    whites[j]++;

                    if (whites[j] >= 2 && blacks[j] >= 2) {
                        lines[j] = 'G';
                    } else lines[j] = 'W';
                }
                idx -= (x - 1);
            }
        }

        for (int i = 0; i < 1000000; i++) {
            if (lines[i] == 'W') white++;
            else if (lines[i] == 'B') black++;
            else if (lines[i] == 'G') gray++;
        }
        System.out.print(white + " " + black + " " + gray);
    }
}