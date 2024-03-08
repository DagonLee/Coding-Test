package boj.String;

import java.io.*;
import java.util.Arrays;

public class boj5525 {
    /*
     * 부분 점수 획득
     * reference 참조하여 해결
     * https://aia1235.tistory.com/30
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        char[] p = new char[2 * n + 1];
        for(int i = 0; i < 3; i++){
            if(i % 2 ==0){
                p[i] = 'I';
            }
            else{
                p[i] = 'O';
            }
        }
        int cursor = 0;
        int count = 0;
        int result = 0;
        while(cursor <= (m - 3)){
            boolean same = true;
            for(int i = cursor; i < (cursor + 3); i++){
                if(s[i] != p[i - cursor]){
                    same = false;
                    break;
                }
            }
            if(same){
                cursor += 2;
                count += 1;
                if(count == n){
                    result +=1;
                    count -= 1;
                }
            }
            else{
                cursor += 1;
                count = 0;
            }
        }
        System.out.println(result);
    }
}
