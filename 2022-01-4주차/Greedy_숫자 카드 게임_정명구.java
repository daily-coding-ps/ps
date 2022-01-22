package 이코테;
import java.util.*;
import java.io.*;
public class GreedyNumberCardGame {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];

        for(int i=0; i<n ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            Arrays.sort(a[i]);
        }
        int max = 0;
        for(int i=0; i<n; i++){
            if(max < a[i][0]);
                max = a[i][0];
            }

        System.out.println(max);

        }
}
