import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.
        int[] digits = new int[binary.length()];
        int sum = 0;

        for (int i=0; i<binary.length(); i++) {
            digits[i] = binary.charAt(i) - '0';
        }

        for (int i=0; i<binary.length(); i++) {
            sum = sum * 2 + digits[i];
        }
        System.out.print(sum);
    }
}