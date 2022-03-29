//나이순 정렬
package 스터디.PS3월4주차;

import java.io.*;
import java.util.*;

public class PS0328_10814 {
    static class Node{
        int age;
        String name;
        int count;

        public Node(int age, String name, int count) {
            this.age = age;
            this.name = name;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            list.add(new Node(age, name, i));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.age == o2.age) {
                    return o1.count - o2.count;
                }
                return o1.age - o2.age;
            }
        });

        for (Node node : list) {
            System.out.println(node.age + " " + node.name);
        }

    }
}
