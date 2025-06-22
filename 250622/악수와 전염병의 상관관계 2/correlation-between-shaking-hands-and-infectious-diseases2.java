import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();

        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt(); // t
            shakes[i][1] = sc.nextInt(); // x
            shakes[i][2] = sc.nextInt(); // y
        }

        // 감염 여부 + 남은 전염 횟수
        int[][] answer = new int[N][2];
        answer[P - 1][0] = 1;
        for (int i = 0; i < N; i++) answer[i][1] = K;

        // 시간순 정렬
        Arrays.sort(shakes, Comparator.comparingInt(a -> a[0]));

        int i = 0;
        while (i < T) {
            int currentTime = shakes[i][0];
            List<int[]> current = new ArrayList<>();

            // 현재 시간대의 모든 악수 수집
            while (i < T && shakes[i][0] == currentTime) {
                current.add(shakes[i]);
                i++;
            }

            // 이 시점의 감염 상태 복사
            int[] infectedBefore = new int[N];
            for (int j = 0; j < N; j++) {
                infectedBefore[j] = answer[j][0];
            }

            // 감염 여부 판단
            for (int[] shake : current) {
                int x = shake[1] - 1;
                int y = shake[2] - 1;

                // x가 감염자라면 전염 시도
                if (infectedBefore[x] == 1 && answer[x][1] > 0) {
                    if (answer[y][0] == 0) answer[y][0] = 1;
                    answer[x][1]--;
                }

                // y가 감염자라면 전염 시도
                if (infectedBefore[y] == 1 && answer[y][1] > 0) {
                    if (answer[x][0] == 0) answer[x][0] = 1;
                    answer[y][1]--;
                }
            }
        }

        for (int j = 0; j < N; j++) {
            System.out.print(answer[j][0]);
        }
    }
}
