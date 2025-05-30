import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        String[] days = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
        int[] date = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int one = 0;
        int two = 0;

        for (int i = 0; i < m1; i++) {
            one += date[i];
        }
        one += d1;

        for (int i = 0; i < m2; i++) {
            two += date[i];
        }
        two += d2;
        // 총 date 각각 구하기

        int divide = 0;
        String answer = "";
        if (one < two) {
            divide = (two - one) % 7;
            answer = days[divide];
        } else {
            divide = (one - two) % 7;
            answer = days[7-divide];
        }
        System.out.print(answer);
    }
}