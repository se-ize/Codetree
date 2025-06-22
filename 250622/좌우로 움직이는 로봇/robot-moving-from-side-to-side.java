import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int MAX = 1000005;

        // 시간 단위 위치 기록용 배열
        int[] posA = new int[MAX];
        int[] posB = new int[MAX];

        // 로봇 A의 이동 기록
        int timeA = 1;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            int dir = (d == 'L') ? -1 : 1;

            for (int j = 0; j < t; j++) {
                posA[timeA] = posA[timeA - 1] + dir;
                timeA++;
            }
        }

        // 로봇 B의 이동 기록
        int timeB = 1;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            int dir = (d == 'L') ? -1 : 1;

            for (int j = 0; j < t; j++) {
                posB[timeB] = posB[timeB - 1] + dir;
                timeB++;
            }
        }

        // 움직임 끝난 뒤에도 마지막 위치 유지하도록 보정
        int maxTime = Math.max(timeA, timeB);
        for (int i = timeA; i < maxTime; i++) posA[i] = posA[timeA - 1];
        for (int i = timeB; i < maxTime; i++) posB[i] = posB[timeB - 1];

        // 바로 전 시간에는 달랐고 현재 시간에 같아진 경우 세기
        int answer = 0;
        for (int i = 1; i < maxTime; i++) {
            if (posA[i - 1] != posB[i - 1] && posA[i] == posB[i]) {
                answer++;
            }
        }

        System.out.print(answer);
    }
}