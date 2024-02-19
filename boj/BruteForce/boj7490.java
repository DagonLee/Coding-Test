package boj.BruteForce;

import java.io.*;
import java.util.*;
public class boj7490 {
    /*
     * start 240219 09:53
     * 1 ~ n 까지의 수를 오름차순으로 쓴 수열에서
     * '+' 나 '-' 또는 ''공백을 숫자 사이에 삽입하여 만든 수식의 값을 계산했을때 0이 되는 수식을 모두 찾아라
     * 
     * 해결방법
     * 1. 모든 경우의 수를 만든다.
     * 2. 계산했을때 0이 된다면 수식을 저장
     * 
     * 핵심 사항
     * 수식이 들어가야하는 갯수를 계산
     * 수식의 모든 케이스를 알아낸다. => 재귀
     * 
     * 데이터
     * ArrayList<int[]> cases // 모든 수식 케이스
     * 
     * 함수
     * 모든 경우의 수를 알아내고 저장하는 함수
     * 한 케이스의 실행 결과를 알아내는 함수
     * 
     * 10:00 설계 완료
     * 실행결과 확인 함수 구현에 시간을 많이 소비 중 10:34
     * 11:09 =>success
     */
    static ArrayList<int[]> cases;
    static ArrayList<String> ans;
    public static boolean canBeZero(int[] stored, int n){ //수식 실행결과 확인함수
        // 0 : '+'
        // 1 : '-'
        // 2 : ''
        int sum = 0;
        int prev = 1;
        int op = -1;
        int idx = 0;
        // printCase(stored);
        while(idx < n){
            if(stored[idx] == 2){
                prev *= 10;
                prev += (idx + 2);
            }
            else{
                if(op == -1){
                    sum += prev;
                }
                if(op == 0){
                    sum += prev;
                }
                else if(op == 1){
                    sum -= prev;
                }
                if(stored[idx] == 0){
                    op = 0;
                }
                else if(stored[idx] == 1){
                    op = 1;
                }
                prev = idx + 2;
            }
            idx ++;
            
        }
        if(prev != 0){
            if(op == -1){
                sum += prev;
            }
            else if(op == 0){
                sum += prev;
            }
            else if(op == 1){
                sum -= prev;
            }
        }
        if(sum == 0){
            return true;
        }
        return false;
    }
    public static String printCase(int[] stored){
        String result = "";
        for(int i = 0; i < stored.length; i++){
            result += (i + 1);
            if(stored[i] == 0){
                result += '+';
            }
            else if(stored[i] == 1){
                result += '-';
            }
            else if(stored[i] == 2){
                result += ' ';
            }
        }
        result += stored.length  + 1;
        return result;
    }
    public static void findAllCases(int curIdx, int limit, int[] stored){
        if(curIdx == limit){
            if(canBeZero(stored, limit)){
                // for(int i = 0; i < stored.length; i++){
                //     System.out.print(stored[i] + " ");
                // }
                ans.add(printCase(stored));

            }
            // for(int i = 0; i < stored.length; i++){
            //     System.out.print(stored[i] + " ");
            // }
            // System.out.println();
            return;
        }
        for(int i = 0; i < 3; i++){
            stored[curIdx] = i;
            findAllCases(curIdx + 1, limit, stored);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 1;i <= t; i++){
            ans = new ArrayList<>();
            cases = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            findAllCases(0, n - 1, new int[n - 1]);
            Collections.sort(ans);
            for(String s : ans){
                System.out.println(s);
            }
            System.out.println();
        }

    }
}
