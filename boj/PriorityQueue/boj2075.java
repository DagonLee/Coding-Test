package boj.PriorityQueue;

import java.io.*;
import java.util.*;

public class boj2075 {
    /*
     * 문제
     * n * n 표에 수가 채워져 있다.
     * 모든 수는 자신의 한 칸 위에 있는 수 보다 크다
     * n 번째 큰수를 구하라
     * 
     * 해결 방법
     * 모든 수를 우선순위 큐에 넣고 정렬 후 n번 째 수를 출력한다.
     * 
     * 동적 배열에 넣은 후 정렬 시간: 2108ms
     * 우선 순위 큐에 넣은 후 출력: 824ms
     * 훨씬 빠르다.
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        int cnt = 1;
        while(cnt < n){
            pq.poll();
            cnt++;
        }
        System.out.println(pq.poll());
    }
}
