import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] penalizedPerson = new int[m];
        int[] student = new int[101];

        for (int i = 0; i < m; i++) {
            penalizedPerson[i] = sc.nextInt();
        }

        int answer = 0;
        for (int person : penalizedPerson) {
            student[person]++;
          if (student[person] >= k) {
                answer = person;
                break;
            }
        }
        System.out.print(answer == 0 ? -1 : answer);
        // Please write your code here.
    }
}