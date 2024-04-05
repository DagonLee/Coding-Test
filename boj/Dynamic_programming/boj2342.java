package boj.Dynamic_programming;

import java.io.*;
import java.util.*;

public class boj2342 {
    /*
     * 문제
     * ddr 게임과 같은 동작을 수행
     * 중점을 0 위:1, 왼쪽 : 2, 아래 : 3, 오른쪽 : 4
     * 비용 관련 룰
     * 중앙에서 다른 지점으로 이동 시 : 2
     * 다른 지점에서 인접한 지점 : 3
     * 반대편으로 이동 : 4
     * 
     * 기존 방법으로 구현하여 fail
     * 질문 게시판에서 dp를 사용하여 해결했다는 힌트를 얻어 다시 시도
     */
    static int calculate(int start, int target){
        if(start == 0){
            return 2;
        }
        if(start == target){
            return 1;
        }
        if(Math.abs(start - target) == 2){
            return 4;
        }
        else{
            return 3;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 500000;
        ArrayList<Integer> com = new ArrayList<>(); 
        while(st.hasMoreTokens()){
            int val = Integer.parseInt(st.nextToken());
            if(val == 0){
                break;
            }
            com.add(val);
        }
        int[][][] dp = new int[com.size() + 1][5][5];
        for(int i = 0; i<= com.size(); i++){
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    dp[i][j][k] = 500000;
                }
            }
        }
        dp[0][0][0] = 0;
        for(int t = 1; t <= com.size(); t++){
            int cur = com.get(t - 1);
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    dp[t][i][cur] = Math.min(dp[t][i][cur], dp[t - 1][i][j] + calculate(j, cur));
                    dp[t][cur][i] = Math.min(dp[t][cur][i], dp[t - 1][i][j] + calculate(j, cur));
                }
            }
            
        }
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(ans > dp[com.size()][i][j]){
                    ans = dp[com.size()][i][j];
                }
            }
        }
        System.out.println(ans);
    }
}
