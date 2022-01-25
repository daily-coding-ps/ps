package 이코테.Greedy;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GreedyQ4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int ans = 1; // 1원부터 만들 수 있는지 체크
        for(int i=0; i<n ;i++){
            if(ans < a[i]){ //현재 만들 수 있지 확인하려는 금액 보다 더 큰 동전이 오면
                break; // 현재 값은 만들 수 없다.
            }
            ans+=a[i];
        }

        System.out.println(ans);
    }
}
