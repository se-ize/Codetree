import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.
        int answer = 0;
        int standard = (11 * 24 * 60) + (11 * 60) + 11;
        int total = (A * 24 * 60) + (B * 60) + C;

        if (total < standard) {
            answer = -1;
        } else {
            answer = total - standard;
        }
        System.out.print(answer);
 
    }
}