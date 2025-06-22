import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt(); // K번의 악수 동안만 전염병 옮김
        int P = sc.nextInt(); // 처음 감염돼있는 개발자
        int T = sc.nextInt();
        int[][] shakes = new int[T][3];
        int[][] answer = new int[N][2];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt(); //t
            shakes[i][1] = sc.nextInt(); //x
            shakes[i][2] = sc.nextInt(); //y
        }

       // 처음 감염된 개발자 설정
       answer[P-1][0] = 1; 
       // 전염 가능 횟수 초기화
       for (int i = 0; i < N; i++) {
        answer[i][1] = K;
       }

       // 시간순으로 악수 기록 정렬
       Arrays.sort(shakes, (a, b) -> Integer.compare(a[0], b[0]));

       for (int i = 0; i < T; i++) {
        int x = shakes[i][1] - 1;
        int y = shakes[i][2] - 1;
        
        // x가 감염자이고 전염 횟수 남아있으면 y 감염 시도
        if (answer[x][0] == 1 && answer[x][1] > 0) {
            if (answer[y][0] == 0) answer[y][0] = 1;
            answer[x][1]--;
        } 
        // y가 감염자이고 전염 횟수 남아있으면 x 감염 시도
        if (answer[y][0] == 1 && answer[y][1] > 0) {
            if (answer[x][0] == 0) answer[x][0] = 1;
            answer[y][1]--;
        } 
       }

       for (int i = 0; i < N; i++) {
        System.out.print(answer[i][0]); // 0-음성, 1-양성
       }
    }
}