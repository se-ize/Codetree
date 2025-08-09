import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // Please write your code here.
        int openCount = 0;
        int pairCount = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                pairCount += openCount;
            }
        }
        System.out.println(pairCount);
    }
}