package boj.math;

import java.io.*;

public class boj1747 {
    /*
     * 소수이면서 팰린드롬(뒤집었을 때, 동일한 문자)인 수를 찾는 문제
     * 에라토스테네스의 체를 이용하여 소수를 판별
     * 투포인터 기법을 통해 앞뒤 값이 같다는 것을 알아내서 반환
     */
     public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[10000001];
        check[1] = true;
        for(int i = 2; i <= 10000000; i++){
            for(int j = i * 2; j <= 10000000; j += i){
                check[j] = true;
            }
        }
        for(int i = n; i <= 10000000; i++){
            if(!check[i]){
                char[] s = Integer.toString(i).toCharArray();
                boolean isPalindrome = true;
                for(int j = 0; j < (s.length / 2); j++){
                    if(s[j] != s[s.length - 1 - j]){
                        isPalindrome = false;
                    }
                }
                if(isPalindrome){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
