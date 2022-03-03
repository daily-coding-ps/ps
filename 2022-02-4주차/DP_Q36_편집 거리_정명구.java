package 이코테.DP;

import java.io.*;

public class Q36 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int[][] d = new int[a.length() + 1][b.length() + 1];

        //초기값 설정
        for (int i = 0; i <= a.length(); i++) {
            d[i][0] = i;
        }

        for (int i = 0; i <= b.length(); i++) {
            d[0][i] = i;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    d[i][j] = d[i - 1][j - 1];
                }else{
                    d[i][j] = Math.min(d[i - 1][j] , Math.min(d[i][j - 1] , d[i - 1][j - 1])) + 1;
                }
            }
        }

        System.out.println(d[a.length()][b.length()]);
    }
}
