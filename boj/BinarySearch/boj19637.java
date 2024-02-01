package boj.BinarySearch;

import java.io.*;
import java.util.*;

public class boj19637 {
    /*
     * start: 240201 15:22
     * 각 칭호에 경계값이 주어지고 캐릭터의 전투력에 맞는 칭호를 출력
     * 
     * 1. 각 칭호의 경계 값과, 칭호명을 저장
     * 2. 캐릭터마다 칭호 경계 값 리스트에서 적절한 칭호를 찾아서 출력
     * 
     * 1st try : timelimit exceeded 15:35
     * 이분 탐색으로 시간단축을 시도
     * https://velog.io/@seunghwanly/binary-search 참고하여 해결
     * 15:55
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n; // 칭호의 개수
        int m; // 캐릭터의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String[] level = new String[n];
        int[] levelLimit = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            level[i] = st.nextToken();
            levelLimit[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            int score = Integer.parseInt(br.readLine());
            int start = 0;
            int end = n - 1;
            while(start < end){
                int mid = (start + end) / 2;
                if(score <= levelLimit[mid]){
                    end = mid;
                }
                else{
                    start = mid + 1;
                }
            }
            sb.append(level[start]);
            sb.append("\n");
            // for(int j = 0; j < n; j++){
            //     if(score <= levelLimit[j]){
            //         sb.append(level[j]);
            //         sb.append("\n");
            //         break;
            //     }
            // }
        }
        System.out.println(sb.toString());
    }
}
