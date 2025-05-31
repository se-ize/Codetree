import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();
        // Please write your code here.
        //A진수로 주어진 수를 10진수로 변환 -> 10진수를 B진수로 변환
        int decimal = 0;
        for (int i=0; i<N.length(); i++) {
            decimal = decimal * A + N.charAt(i) - '0';
        }

        int answer = 0;
        int cnt = 0;
        int[] digits = new int[100000];
        while (true) {
            if (decimal < B) {
                digits[cnt++] = decimal;
                break;
            }
            digits[cnt++] = decimal % B;
            decimal /= B;
        }

        for (int i=cnt-1; i>=0; i--) {
            System.out.print(digits[i]);
        }
    }
}