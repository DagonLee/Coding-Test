package boj.Graph;

import java.io.*;
import java.util.*;
public class boj16953 {
    /*
     * 240310 17:28
     * 문제
     * A -> B로 바꾸려고 할떄 
     * 가능한연산
     * 1. 2를 곱한다.
     * 2. 1을 수의 가장 오른쪽에 추가한다.
     * A를 B로 바꾸는데 필요한 연산의 최솟값을 구하라
     * 
     * 해결방법
     * BFS를 이용하여 최단 거리를 구한다.
     * 수행 방법
     * 연산의 개수를 저장하는 배열을 등록 => 메모리 초과
     *
     * 큐의 데이터로 입력한 후 최초로 B생성시 반환하고 종료
     */
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        Deque<long[]> q = new ArrayDeque<>();
        
        q.addLast(new long[]{a, 1});
        while(!q.isEmpty()){
            long[] now = q.pollFirst();
            if(now[0] == b){
                System.out.println(now[1]);
                return;
            }
            if(b >= (now[0] * 2)){
                q.addLast(new long[]{now[0] * 2, now[1] + 1});
            }
            if(b >= (now[0] * 10 + 1)){
                q.addLast(new long[]{now[0] * 10 + 1, now[1] + 1});
            }
        }
        System.out.println(-1);
    }
}