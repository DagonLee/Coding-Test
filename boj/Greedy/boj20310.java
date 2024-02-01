package boj.Greedy;

import java.io.*;

public class boj20310 {
    /*
     * start:15:00
     * S 문자열 0, 1로 구성
     * 0과 1 개수의 절반을 제거하여 새로운 문자열 s' 생성
     * s'로 가능한 문자열 중 사전순으로 가장 빠른 것은?
     * 1. 0 과 1의 개수를 센다
     * 2. 1의 개수 절반 만큼 앞에서 부터 제거
     * 3. 0의 개수 절반 만큼 뒤에서 제거
     * end : 15:12, 1st try success
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charList = br.readLine().toCharArray();
        int zeroCnt = 0;
        int oneCnt = 0;
        for(char c : charList){
            if(c == '0'){
                zeroCnt++;
            }
            else{
                oneCnt++;
            }
        }
        zeroCnt /= 2;
        oneCnt /= 2;
        String tmpString = "";
        for(char c :charList){
            if(oneCnt > 0 && c == '1'){
                oneCnt--;
            }
            else{
                tmpString += c;
            }
        }
        char[] tmpCharList = tmpString.toCharArray();
        String ans = "";
        for(int i = tmpCharList.length - 1; i >= 0; i--){
            if(zeroCnt > 0 && tmpCharList[i] == '0'){
                zeroCnt--;
            }
            else{
                ans = tmpCharList[i] + ans;
            }
        }
        System.out.println(ans);
    }
}
