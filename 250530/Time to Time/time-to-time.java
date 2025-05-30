import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.
        int all = 0;
        int sub = 0;

        all = c * 60 + d;
        sub = a * 60 + b;

        System.out.println(all-sub);
    }
}