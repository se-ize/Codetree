import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        String[] addresses = new String[n]; // XXX-XXX
        String[] regions = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            addresses[i] = sc.next();
            regions[i] = sc.next();
        }
        // Please write your code here.
        // 사전순으로 이름이 가장 느린 사람의 자료 출력
        // class에 각 사람 정보 담은 n개 객체 생성

        People latest = new People(names[0], addresses[0], regions[0]);
        for (int i = 1; i < n; i++) {
            People current = new People(names[i], addresses[i], regions[i]);
            if (latest.compareTo(current) < 0) latest = current;
        }

        System.out.println("name " + latest.name);
        System.out.println("addr " + latest.address);
        System.out.println("city " + latest.region);
    }
}

class People implements Comparable<People>{
    public String name;
    public String address;
    public String region;

    public People(String name, String address, String region) {
        this.name = name;
        this.address = address;
        this.region = region;
    }

    @Override
    public int compareTo(People other) {
        return this.name.compareTo(other.name);
    }
}