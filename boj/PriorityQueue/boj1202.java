package boj.PriorityQueue;

import java.io.*;
import java.util.*;

public class boj1202 {
    /*
     * 문제
     * n개의 보석이 주어지고 각 보석은 무게와 가격을 가지고 있다.
     * 가방 k가 주어지고 각 가방은 담을 수 있는 최대 무게 c가 주어진다.
     * 가방에는 최대 한 개의 보석만 넣을 수 있을 때, 가져갈 수 있는 보석의 최대 가격 합을 구하라
     * 
     * 해결 방법
     * 최대한 많은 가격을 가져가려면 가격순으로 가장 높은 보석이고 
     * 무게 제한에 안걸리면서 가장 큰 무게를 가지는 보석을 가져가야 이후의 가방들에 높은 가치를 가지는 보석이 들어간다.
     * 그래서 가방 또한 가용 무게가 가장 큰 순서대로 정렬 후 가격이 가장 높고 무게제한에 가장 가까운 보석을 넣어야한다.
     * => 실패 
     * 다른 코드 참고하여 구현
     * https://jaimemin.tistory.com/760 => c++ 구현 방식
     * 가방의 무게 제한과 보석의 무게를 오름차순으로 정렬하여 각 가방을 무게의 오름차순으로 순회하며 
     * 허용 가능한 보석들을 가치의 내림 차순으로 정렬되는 우선순위 큐에 넣는다.
     * 
     * 문제 접근 회고
     * 최대 가치를 가지는 경우라고 생각하여 배낭문제와 비슷한 DP 접근법을 생각했으나
     * 문제의 조건에서 가방이 여러개 주어지므로 다른 접근방법이 필요했다.
     * 단순 무작위 대입법 사용시 시간 초과가 발생하므로 최적화하는 알고리즘 또는 자료구조가 필요
     * 우선순위 큐를 사용하여 무게가 가장 큰 것 부터 접근하려 시도했으나 반례가 존재
     * 다른 코드를 참고하여 가방 무게의 오름차순으로 가치들의 최고값들을 더해가면서 갱신
     */
    static class Jewel implements Comparable<Jewel>{
        int weight;
        int value;
        Jewel(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
        public int compareTo(Jewel o){
            return weight - o.weight;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Jewel[] jewels= new Jewel[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }
        Arrays.sort(jewels);
        Integer[] bags = new Integer[k];
        for(int i = 0; i < k; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        long ans = 0;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            while(cnt < n && jewels[cnt].weight <= bags[i]){
                pq.add(-jewels[cnt].value);
                cnt++;
            }
            if(!pq.isEmpty()){
                ans += (-pq.poll());
            }
        }
        System.out.println(ans);
    }
}