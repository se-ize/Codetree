import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // Please write your code here.
        LinkedList<Integer> q = new LinkedList<>();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        for (int i = 0; i < n; i++) {
            if (!q.isEmpty()) {
                idx = (idx + k - 1) % q.size();
                System.out.print(q.remove(idx));
            }
            System.out.print(" ");
        }
    }
} 