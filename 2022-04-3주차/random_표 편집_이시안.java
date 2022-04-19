package programmers;

import java.util.Stack;

public class EditTable {

    Node[] nodeArr = new Node[1000001];

    public String solution(int n, int k, String[] cmd) {
        for (int i = 0; i < n; i++) {
            nodeArr[i] = new Node();
        }

        // 각 노드 연결
        for (int i = 1; i < n; i++) {
            nodeArr[i - 1].next = nodeArr[i];
            nodeArr[i].prev = nodeArr[i - 1];
        }

        Node curr = nodeArr[k]; // 시작 노드 설정
        Stack<Node> stack = new Stack<>(); // 제거된 노드를 담을 스택

        // 각 명령어를 처리
        for (String s : cmd) {
            if (s.charAt(0) == 'U') {
                int x = Integer.parseInt(s.substring(2));
                for (int i = 0; i < x; i++) {
                    curr = curr.prev;
                }
            } else if (s.charAt(0) == 'D') {
                int x = Integer.parseInt(s.substring(2));
                for (int i = 0; i < x; i++) {
                    curr = curr.next;
                }
            } else if (s.charAt(0) == 'C') {
                stack.push(curr);
                curr = curr.removeNode();
            } else {
                Node node = stack.pop();
                node.restore();
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nodeArr[i].removed) {
                answer.append("X");
            } else {
                answer.append("O");
            }
        }

        return answer.toString();
    }


    class Node {
        boolean removed;
        Node prev;
        Node next;

        // 현재 노드를 제거하는 메서드
        Node removeNode() {
            this.removed = true;

            Node prev = this.prev;
            Node next = this.next;

            if (prev != null) {
                prev.next = next;
            }

            if (next != null) {
                next.prev = prev;
                return this.next;
            } else {
                return this.prev;
            }
        }

        // 노드를 복구하는 메서드
        void restore() {
            this.removed = false;
            Node prev = this.prev;
            Node next = this.next;

            if (prev != null) {
                prev.next = this;
            }
            if (next != null) {
                next.prev = this;
            }
        }
    }
}
