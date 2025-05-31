import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int[] digits = new int[n];
        int cnt = 0;

        while (true) {
            if (n == 0) {
                System.out.print(0);
                break;
            }

            if (n < 2) {
                digits[cnt++] = n;
                break;
            }
            digits[cnt++] = n % 2;
            n /= 2;
        }

        for (int i = cnt-1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
    }
}