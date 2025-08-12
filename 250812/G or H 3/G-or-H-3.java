import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);
            int score = (c == 'G') ? 1 : 2;
            arr[i][0] = pos;
            arr[i][1] = score;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int left = 0;
        int sum = 0;
        int maxSum = 0;

        // 투포인터 / 슬라이딩 윈도우
        for (int right = 0; right < n; right++) {
            sum += arr[right][1]; // 현재 사람 점수
            
            // 구간 크기가 k 초과시 왼쪽 포인터 이동
            while (arr[right][0] - arr[left][0] > k) {
                sum -= arr[left][1];
                left++;
            }

            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);

    }
}