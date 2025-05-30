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

        for (int i = 0; i < m1 - 1; i++) { // -1 유의!! - 전 월까지만 더해야함
            one += date[i];
        }
        one += d1;

        for (int j = 0; j < m2 - 1; j++) {
            two += date[j];
        }
        two += d2;
        // 총 date 각각 구하기

        int divide = 0;
        String answer = "";
        if (one < two) {
            divide = (two - one) % 7;
            answer = days[divide];
        } else if (one > two) {
            divide = (one - two) % 7;
            answer = days[7-divide];
        } else { //주의!! 같은 날짜 경우 존재
            answer = days[0];
        }
        System.out.print(answer);
    }
}