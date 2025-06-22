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
       // 악수 설정
       for (int i = 0; i < N; i++) {
        answer[i][1] = K;
       }

       // 시간순으로 정렬
       Arrays.sort(shakes, (a, b) -> Integer.compare(a[0], b[0]));

       // 각 감염된 사람들의 악수를 설정해야함 
       for (int i = 0; i < T; i++) {
        for (int j = 0; j < N; j++) {
            if (answer[j][0] == 1 && shakes[i][1] == j+1) {
                    if (answer[j][1] > 0) {
                        answer[shakes[i][2] - 1][0] = 1;
                        answer[j][1]--;
                    }
                } else if (answer[j][0] == 1 && shakes[i][2] == j+1) {
                    if (answer[j][1] > 0) {
                        answer[shakes[i][1] - 1][0] = 1;
                        answer[j][1]--;
                    }
                }
        }
       }

       for (int i = 0; i < N; i++) {
        System.out.print(answer[i][0]); // 0-음성, 1-양성
       }
    }
}