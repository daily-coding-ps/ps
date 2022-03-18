import java.util.*;

class Solution {
    static boolean[] check = new boolean[3];
    static long max = 0;
    static ArrayList<Long> numbers = new ArrayList<>();
    static ArrayList<Character> oper = new ArrayList<>();

    public long solution(String expression) {
        char[] op = {'*', '-', '+'};

        String number = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                oper.add(expression.charAt(i));
                numbers.add(Long.valueOf(number));
                number = "";
            }else{
                number += expression.charAt(i);
            }

        }
        numbers.add(Long.valueOf(number));

        dfs(0, op, "");

        return max;
    }

    static void dfs(int depth, char[] op, String select) {
        if (depth == 3) {
            max = Math.max(max, calc(select));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if(!check[i]){
                check[i] = true;
                dfs(depth + 1, op, select + op[i]);
                check[i] = false;
            }
        }
    }

    static long calc(String select){
        ArrayList<Long> copyNumbers = (ArrayList<Long>) numbers.clone();
        ArrayList<Character> copyOper = (ArrayList<Character>) oper.clone();

        for (int k = 0; k < select.length(); k++) {
            for (int i = 0; i < copyOper.size(); i++) {
                long result = 0;

                if (select.charAt(k) == copyOper.get(i)) {
                    if (copyOper.get(i) == '*') {
                        result = copyNumbers.get(i) * copyNumbers.get(i + 1);
                    }
                    if (copyOper.get(i) == '+') {
                        result = copyNumbers.get(i) + copyNumbers.get(i + 1);
                    }
                    if (copyOper.get(i) == '-') {
                        result = copyNumbers.get(i) - copyNumbers.get(i + 1);
                    }

                    copyNumbers.remove(i + 1);
                    copyNumbers.set(i, result);
                    copyOper.remove(i);

                    i = i - 1;
                }
            }
        }

        return Math.abs(copyNumbers.get(0));
    }
}