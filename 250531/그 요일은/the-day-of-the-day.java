import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        // Please write your code here.

        int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] days = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
        int one = 0;
        int two = 0;

        for (int i = 0; i < m1-1; i++) {
            one += date[i];
        }
        one += d1;

        for (int i = 0; i < m2-1; i++) {
            two += date[i];
        }
        two += d2;

        int index = 0;
        int diff = (two - one) % 7;
        int answer = (two - one) / 7;

        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(A)) index = i;
        }

        if (index <= diff) answer++;

        System.out.print(answer);

    }
}