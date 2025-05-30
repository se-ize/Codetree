import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        int all = 0;
        int sub = 0;

        while (m2 > 0) {
            if (m2 == 2) {
                all += 28;
            } else {
                all += 31;
            }
            m2--;
        }

        all += d2;

        while (m1 > 0) {
            if (m1 == 2) {
                sub += 28;
            } else {
                sub += 31;
            }
            m1--;
        }

        sub += d1;

        if (m1 == m2 && d1 == d2) {
            all = 1;
            sub = 0;
        }

        System.out.print(all-sub);
        
    }
}