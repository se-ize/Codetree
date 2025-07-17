import java.util.*;
public class Main {
    public static HashMap<String, Integer> hashMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > maxCount) maxCount = entry.getValue();
        }

        System.out.print(maxCount);
        // Please write your code here.
    }
}