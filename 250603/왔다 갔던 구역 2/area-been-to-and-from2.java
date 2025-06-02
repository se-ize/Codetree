import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] lines = new int[1000];
        int idx = 500;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            if (dir == 'R') {
                for (int j = idx; j < idx + x; j++) {
                    lines[j]++;
                }
                idx += x;
            } else {
                for (int j = idx - 1; j >= idx - x; j--) {
                    lines[j]++;
                }
                idx -= x;
            }
        }

        int count = 0;
        for (int i = 0; i < 1000; i++) {
            if (lines[i] >= 2) {
                count++;
            }
        } 
        System.out.print(count);
    }
}