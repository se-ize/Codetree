import java.util.*;
class Node {
    int id;
    Node prev, next;

    public Node(int id) {
        this.id = id;
        this.prev = this.next = null;
    }

    static void insertPrev(Node cur, Node singleton) {
        singleton.prev = cur.prev;
        singleton.next = cur;
        if (cur.prev != null) {
            cur.prev.next = singleton;
        }
        cur.prev = singleton;
    }
    static void insertNext(Node cur, Node singleton) {
        singleton.next = cur.next;
        singleton.prev = cur;
        if (cur.next != null) {
            cur.next.prev = singleton;
        }
        cur.next = singleton;
    }
    static void pop(Node cur) {
        if (cur.prev != null) cur.prev.next = cur.next;
        if (cur.next != null) cur.next.prev = cur.prev;
        cur.prev = cur.next = null;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드의 총 개수
        int q = sc.nextInt(); // 연산 횟수
        // Please write your code here.
        Node[] nodes = new Node[100005];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            int j = sc.nextInt();

            if (type == 1) {
                Node.pop(nodes[j]);
            } else if (type == 2) {
                int k = sc.nextInt();
                Node.insertPrev(nodes[j], nodes[k]);
            } else if (type == 3) {
                int k = sc.nextInt();
                Node.insertNext(nodes[j], nodes[k]);
            } else {
                System.out.print((nodes[j].prev == null ? 0 : nodes[j].prev.id) + " ");
                System.out.println((nodes[j].next == null ? 0 : nodes[j].next.id));
            }
        }
        for (int i = 1; i <= n; i++)
            System.out.print((nodes[i].next == null ? 0 : nodes[i].next.id) + " ");
    }
}