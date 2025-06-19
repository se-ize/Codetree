import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int maxTime = 1000 * 1000;
        int[] nArr = new int[maxTime];
        int[] mArr = new int[maxTime];
        // 시간에 대한 배열 설정

        int nPos = 0;
        int timeIdx = 0;

        for (int i = 0; i < n; i++) {
            char dir = sc.next().charAt(0);
            int t = sc.nextInt();
            int pos = (dir == 'R') ? 1 : -1;
            for (int j = 0; j < t; j++) {
                nPos += pos;
                nArr[timeIdx++] = nPos;
            }
        }

        int mPos = 0;
        timeIdx = 0;

        for (int i = 0; i < m; i++) {
            char dir = sc.next().charAt(0);
            int t = sc.nextInt();
            int pos = (dir == 'R') ? 1 : -1;
            for (int j = 0; j < t; j++) {
                mPos += pos;
                mArr[timeIdx++] = mPos;
            }
        }

        int answer = -1;
        for (int i = 0; i < timeIdx; i++) {
            if (nArr[i] == mArr[i]) {
                answer = i + 1;
                break;
            }
        }

        System.out.print(answer);
        // Please write your code here.
    }
}