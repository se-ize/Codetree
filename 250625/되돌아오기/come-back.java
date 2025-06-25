import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0;
        int answer = 0;
        boolean found = false;

        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();
            
            for (int j = 1; j <= dist; j++) {
                x += dx[direction(dir)];
                y += dy[direction(dir)];
                answer++;
                if (x == 0 && y == 0) {
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        System.out.print(found ? answer : -1);
    }
    public static int direction(char dir) {
        switch (dir) {
            case 'E': return 0;
            case 'S': return 1;
            case 'W': return 2;
            case 'N': return 3;
            default: return -1;
        }
    }
}