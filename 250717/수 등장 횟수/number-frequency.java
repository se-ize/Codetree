import java.util.*;
public class Main {
    public static HashMap<Integer, Integer> hashMap = new HashMap<>();
    // key - 수열의 원소, value - 등장 횟수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
            System.out.print(hashMap.getOrDefault(queries[i], 0) + " ");
        }
        // Please write your code here.
    }
}