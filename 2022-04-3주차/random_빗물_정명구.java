//빗물
package 스터디.PS4월3주차;

import java.io.*;
import java.util.*;

public class PS0420_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] wall = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            wall[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            int leftWall = wall[i];
            int rightWall = wall[i];
            //왼쪽 기둥 찾기
            for (int k = i - 1; k >= 0; k--) {
                if (wall[k] > leftWall) {
                    leftWall = Math.max(leftWall, wall[k]);
                }
            }
            //오른쪽 기둥 찾기
            for (int k = i + 1; k < m; k++) {
                if (wall[k] > rightWall) {
                    rightWall = Math.max(rightWall, wall[k]);
                }
            }
            int tempWall = Math.min(leftWall, rightWall);

            //양 옆의 벽중 작은 벽이 현재 벽 보다 높을 때
            if (tempWall > wall[i]) {
                ans += tempWall - wall[i];
            }
        }

        System.out.println(ans);
    }
}
