import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("push")) {
                q.add(sc.nextInt());
            } else if (s.equals("front")) {
                System.out.println(q.peek());
            } else if (s.equals("size")) {
                System.out.println(q.size());
            } else if (s.equals("empty")) {
                System.out.println(q.isEmpty() ? 1 : 0);
            } else if (s.equals("pop")) {
                System.out.println(q.poll());
            }
        }
    }
}