import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int MAX = 1000000;
        // 시간 단위로 로봇의 위치가 어떻게 변했는지 추적
        int[] posA = new int[MAX];
        int[] posB = new int[MAX];

        int lenA = 1; // 시작점 포함
        int nowA = 0;
        posA[0] = nowA;
    
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
            int dir = (d == 'L') ? -1 : 1;
            for (int j = 0; j < t; j++) {
                nowA += dir;
                posA[lenA++] = nowA;
            }
        }

        int lenB = 1; // 시작점 포함
        int nowB = 0;
        posB[0] = nowB;
    
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            // Please write your code here.
            int dir = (d == 'L') ? -1 : 1;
            for (int j = 0; j < t; j++) {
                nowB += dir;
                posB[lenB++] = nowB;
            }
        }

        // 로봇이 멈춘 후에도 같은 위치에 계속 머무르도록 보정
        // 한쪽 로봇의 움직임이 끝난 후에도 다른 쪽이 아직 움직일 수 있어서
        // 짧은 쪽을 가만히 있는 상태로 연장
        int len = Math.max(lenA, lenB);
        for (int i = lenA; i < len; i++) posA[i] = posA[lenA - 1];
        for (int i = lenB; i < len; i++) posB[i] = posB[lenB - 1];
        
        // Please write your code here.
        int answer = 0;
        for (int i = 1; i < len; i++) {
            if (posA[i-1] != posB[i-1] && posA[i] == posB[i]) answer++;
        }
        System.out.print(answer);
    }
}