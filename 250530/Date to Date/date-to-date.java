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
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i=0; i<m2-1; i++) {
            all += days[i];
        }
        all += d2;

        for (int j=0; j<m1-1; j++) {
            sub += days[j];
        }
        sub += d1;

        System.out.print(all-sub+1);
        
    }
}