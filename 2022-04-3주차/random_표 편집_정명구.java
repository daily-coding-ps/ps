import java.util.*;

class Solution {
    class Node{
        boolean remove;
        Node prev;
        Node next;
    }

    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        Node[] NodeArr = new Node[n + 1];

        for (int i = 0; i < n; i++) {
            NodeArr[i] = new Node();
        }
        for (int i = 1; i < n; i++) {
            NodeArr[i - 1].next = NodeArr[i];
            NodeArr[i].prev = NodeArr[i - 1];
        }

        Node now = NodeArr[k];
        Stack<Node> stack = new Stack<>();

        for (String s : cmd) {
            String[] word = s.split(" ");
            if (s.charAt(0) == 'U') {
                int x = Integer.parseInt(word[1]);
                for (int i = 0; i < x; i++) {
                    now = now.prev;
                }
            }

            if (s.charAt(0) == 'D') {
                int x = Integer.parseInt(word[1]);
                for (int i = 0; i < x; i++) {
                    now = now.next;
                }
            }

            if (s.charAt(0) == 'C') {
                stack.push(now);
                now.remove = true;
                Node up = now.prev;
                Node down = now.next;

                if (up != null) {
                    up.next = down;
                }

                if (down != null) {
                    down.prev = up;
                    now = down;
                }else{
                    now = up;
                }
            }

            if (s.charAt(0) == 'Z') {
                Node node = stack.pop();
                node.remove = false;
                Node up = node.prev;
                Node down = node.next;
                if (up != null) {
                    up.next = node;
                }
                if (down != null) {
                    down.prev = node;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if(NodeArr[i].remove){
                sb.append('X');
            }else{
                sb.append('O');
            }
        }
        answer = sb.toString();
        return answer;
    }
}