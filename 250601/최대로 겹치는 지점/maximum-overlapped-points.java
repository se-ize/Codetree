import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lines = new int[100];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            for (int j = x1; j <= x2; j++) {
                lines[j]++;
            }
        }

        int max = 0;
        for (int line : lines) {
            if (max < line) max = line;
        }

        System.out.print(max);
    }
}