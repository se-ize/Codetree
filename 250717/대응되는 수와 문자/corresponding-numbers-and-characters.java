import java.util.*;
public class Main {
    public static HashMap<String, Integer> map = new HashMap<>();
    public static HashMap<Integer, String> revMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // N개의 정수
        int m = sc.nextInt(); // 조사해야 할 M개의 정수 혹은 문자열
        String[] words = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
            map.put(words[i], i);
            revMap.put(i, words[i]);
        }
        // Please write your code here.
        for (int i = 1; i <= m; i++) { //조사해야함
        // 정수라면 해당 key 출력 -> hashMap에서 Key값이 존재안하면?
        // 정수아니면 해당 value 출력
            String s = sc.next();
            int answer = map.getOrDefault(s, 0);
            if (answer > 0) System.out.println(answer);
            else System.out.println(revMap.get(Integer.parseInt(s)));
        }
    }
}