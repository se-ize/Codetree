import java.util.*;
public class Main {
    public static LinkedList<Integer> l = new LinkedList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            // Please write your code here
            if (command.equals("push_front")) l.addFirst(sc.nextInt());
            if (command.equals("push_back")) l.addLast(sc.nextInt());
            if (command.equals("pop_front")) System.out.println(l.pollFirst());
            if (command.equals("pop_back")) System.out.println(l.pollLast());
            if (command.equals("size")) System.out.println(l.size());
            if (command.equals("empty")) System.out.println(l.isEmpty() ? 1 : 0);
            if (command.equals("front")) System.out.println(l.peekFirst());
            if (command.equals("back")) System.out.println(l.peekLast());
        }
    }
}