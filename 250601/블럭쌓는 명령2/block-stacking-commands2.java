import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] block = new int[N];
        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            for (int j = A-1; j <= B-1; j++) {
                block[j]++;
            }
        }
        // Please write your code here.
      
        Arrays.sort(block);
        System.out.print(block[N-1]);
    }
}