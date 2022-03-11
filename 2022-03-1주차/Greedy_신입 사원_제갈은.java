import java.util.*;
import java.io.*;
 
public class Main{
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int size = Integer.parseInt(br.readLine());
            int[] arr = new int[size+1];
 
            for(int i=0;i<size;i++){
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                arr[start] = end;
            }
 
            int result = 1;
            int standard = arr[1];
            for(int i=2;i<=size;i++){
                if(standard > arr[i]){
                    result ++;
                    standard = arr[i];
                }
            }
            System.out.println(result);
        }
    }
}
