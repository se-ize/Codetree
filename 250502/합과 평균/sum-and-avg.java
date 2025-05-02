import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        double avg = (A+B) / 2.0;
        System.out.print((A+B) + " ");
        System.out.printf("%.1f", avg);
    }
}