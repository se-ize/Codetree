import java.util.*;
public class Main {
    public static HashMap<String, Integer> hashMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxCount = 0;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
            maxCount = Math.max(maxCount, hashMap.get(arr[i]));
        }

        // for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
        //     if (entry.getValue() > maxCount) maxCount = entry.getValue();
        // }

        System.out.print(maxCount);
        // Please write your code here.
    }
}