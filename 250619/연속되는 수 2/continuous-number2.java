import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] repeats = new int[1001];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (i > 0 && arr[i] == arr[i-1]) repeats[arr[i]]++;
        }

        int max = 0;
        int answer = 0;
        for (int repeat : repeats) {
            if (repeat > max) answer = repeat + 1;
        }

        System.out.print(answer);
        // Please write your code here.
    }
}