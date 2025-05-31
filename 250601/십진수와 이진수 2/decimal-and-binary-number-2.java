import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.
        int decimal = 0;
        int decimal17 = 0;

        for (int i=0; i<binary.length(); i++) {
            decimal = decimal * 2 + binary.charAt(i) - '0';
        }
        decimal17 = decimal * 17;

        int cnt = 0;
        int[] digits = new int[10];

        while (true) {
            if (decimal17 < 2) {
                digits[cnt++] = decimal17;
                break;
            }
            digits[cnt++] = decimal17 % 2;
            decimal17 /= 2;
        }
        
        for (int i=cnt-1; i>=0; i--) {
            System.out.print(digits[i]);
        }

    }
}