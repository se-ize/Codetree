import java.util.*;

public class Main {
    public static HashMap<Integer, Integer> m = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("add")) m.put(sc.nextInt(), sc.nextInt());
            if (s.equals("remove")) m.remove(sc.nextInt());
            if (s.equals("find")) {
                int value = m.getOrDefault(sc.nextInt(), 0);
                System.out.println(value > 0 ? value : "None");
            }
        }
    }
}