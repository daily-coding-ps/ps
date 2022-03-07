//신입 사원
package 이코테.Greedy;

import java.io.*;
import java.util.*;

public class PS0307_1946 {
    static class People {
        int interview;
        int document;

        public People(int interview, int document) {
            this.interview = interview;
            this.document = document;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            ArrayList<People> people = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int interview = Integer.parseInt(st.nextToken());
                int document = Integer.parseInt(st.nextToken());

                people.add(new People(interview, document));
            }

            Collections.sort(people, new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    return o1.interview - o2.interview;
                }
            });
            int ans = 1;
            int tempRanking = people.get(0).document;
            for (int i = 1; i < n; i++) {
                if (tempRanking > people.get(i).document) {
                    tempRanking = people.get(i).document;
                    ans++;
                }
            }
            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }

}
