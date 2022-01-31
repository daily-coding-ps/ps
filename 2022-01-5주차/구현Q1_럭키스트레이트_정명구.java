package 이코테.Simulation;

import java.io.*;


public class simulQ1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        int left = 0;
        int right = 0;

        for(int i=0; i<n/2; i++){
            left += s.charAt(i) - '0';
        }
        for(int i=n/2; i<n; i++){
            right += s.charAt(i) - '0';
        }

        System.out.println(left == right ? "LUCKY" : "READY");

    }
}
