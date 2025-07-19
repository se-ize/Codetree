import java.util.*;

class Node {
    String data;
    Node prev, next;
    public Node(String data) {
        this.data = data;
        this.prev = this.next = null;
    }

    // cur 앞에 singleton 삽입
    static void insertPrev(Node cur, Node singleton) {
        singleton.prev = cur.prev;
        singleton.next = cur;
        if (cur.prev != null) {
            cur.prev.next = singleton;
        }
        cur.prev = singleton;
    }

    // cur 뒤에 singleton 삽입
    static void insertNext(Node cur, Node singleton) {
        singleton.next = cur.next;
        singleton.prev = cur;
        if (cur.next != null) {
            cur.next.prev = singleton;
        }
        cur.next = singleton;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sInit = sc.nextLine();
        Node cur = new Node(sInit);

        int n = sc.nextInt();
        // Please write your code here.
        for (int i = 0; i < n; i++) {
            int opr = sc.nextInt();
            if (opr == 1) {
                String com = sc.next();
                Node newNode = new Node(com);
                Node.insertPrev(cur, newNode);
            } else if (opr == 2) {
                String com = sc.next();
                Node newNode = new Node(com);
                Node.insertNext(cur, newNode);
            } else if (opr == 3) {
                if (cur.prev != null) cur = cur.prev;
            } else {
                if (cur.next != null) cur = cur.next;
            }
            System.out.print((cur.prev != null ? cur.prev.data : "(Null)") + " ");
            System.out.print(cur.data + " ");
            System.out.println((cur.next != null ? cur.next.data : "(Null)") + " ");
        }
        
    }
}