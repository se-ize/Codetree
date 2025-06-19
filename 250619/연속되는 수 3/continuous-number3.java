import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int max = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] * arr[i-1] > 0) {
                count++; 
                if (count > max) {
                    max = count;
                }
            } else {
                count = 1;
            }
        }

        System.out.print(max);
        // Please write your code here.
    }
}