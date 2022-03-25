package 스터디.PS3월4주차;

import java.io.*;
import java.util.*;

public class PS0325_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else if (o1.length() == o2.length()){
                    int a = 0, b = 0;

                    for (int i = 0; i < o1.length(); i++) {
                        if (Character.isDigit(o1.charAt(i))) {
                            a += (o1.charAt(i) - '0');
                        }
                        if (Character.isDigit(o2.charAt(i))) {
                            b += (o2.charAt(i) - '0');
                        }
                    }
                    if(a != b){
                        return a - b;
                    }else{
                        return o1.compareTo(o2);
                    }
                }else{
                    return o1.compareTo(o2);
                }
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }
}
