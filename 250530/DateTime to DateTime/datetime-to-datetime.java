import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.
        int answer = 0;
        int standard = 11 * 60 + 11;
        int input = B * 60 + C;

        answer += (A - 11) * 24 * 60; // Days

        if (input > standard) {
            answer += input - standard;
        } else {
            answer += standard - input;
        }

        if (A < 11 || (A == 11 && B < 11) && (A == 11 && B == 11 && C < 11)) answer = -1;

        System.out.print(answer);
 
    }
}