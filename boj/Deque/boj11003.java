package boj.Deque;

import java.io.*;
import java.util.*;

public class boj11003{
    /*
    240303 13:22
     * 문제
     * n개의 수 A1 ~ An과 l이 주어진다.
     * Di = Ai-l + 1 ~ Ai 중 최솟값, 이때 i <= 0 인 Ai는 무시
     * ex) 
     * l = 3
     * D1 = A-1 ~ A1 중 최솟값, =>A1
     * D3 = A1 
     * D4 = A2 ~ A1
     * 
     * 해결방법
     * 큐에 넣어가면서 최솟값을 갱신 한다.
     * 큐의 크기가 l을 넘어가면 앞의 수를 poll, 만약 최솟값이고 그 카운트를 -1, 
     * 
     * 1. 큐의 사이즈가 l 이라면 poll 연산 수행, poll 한 값을 우선순위 큐에서도 제거하고  3,4번 수행
     * 2. 큐 사이즈가 l 미만이라면 3,4번 수행
     * 3. 우선순위 큐와 큐에 값을 넣는다. 
     * 4. 우선순위 큐에서 가장 작은 값을 가져와서 출력에 추가
     * =>시간 초과
     * 
     * reference 참조
     * https://ansohxxn.github.io/boj/11003/#google_vignette
     * l을 제한 시간의 개념으로 생각
     * 덱에 들어온 시점과 값을 저장한다.
     * 덱의 가장 앞에는 항상 가장 작은 수가 있도록 한다.
     * 
     * 1. 가장 앞에 있는 수가 제한 시간을 초과한 경우 poll
     * 2. 뒤에서 부터 현재 들어온 값보다 큰 경우 가장 작은 수가 될 수가 없으므로 poll
     * 3. 현재 들어온 값을 뒤에 추가, 가장 앞의 값을 가져와서 출력스트림에 추가
     * 
     */
    private static class data{
        int idx;
        int val;
        data(int idx, int val){
            this.idx = idx;
            this.val = val;
        }        
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, l;
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<data> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(!dq.isEmpty() && i == dq.getFirst().idx + l){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.getLast().val > cur){
                dq.pollLast();
            }
            dq.addLast(new data(i, cur));
            sb.append(dq.getFirst().val + " ");
        }
        System.out.println(sb.toString());
    }
}
