package boj.not_classified;

import java.io.*;
import java.util.*;
public class boj1446 {
    /*
     * start 240208 21:44
     * 문제
     * D 킬로 미터 길이 고속도로에서 
     * n 개의 지름길이 주어진다.
     * 운전할 거리의 최솟값을 구하라
     * 
     * 해결방법
     * 1. 길을 갈 수 있는 모든 경우의 수를 확인
     * 2. 2 ^ n 가지 경우를 모두 확인
     * 
     * 접근 방법이 잘못된 것 같다고 판단, 22:23
     * reference 참고 예정
     * 
     * 240209 12:29
     * 검색결과 크게 두가지 방법으로 풀이 가능
     * 1. 다익스트라를 활용한 풀이
     * 2. DP를 이용한 풀이
     * 12:48 초기 풀이를 기반으로 다익스트라로 수정하려 했으나 문제부터 잘못이해한 것을 파악 다시 처음부터 구현
     * 문제
     * 지름길로만 갈 수 있는 D 킬로 미터의 길이 있다. 이 길을 최소길이로 운전하고 싶다.
     * 지름길의 개수 n(n <= 12, 양의 정수), 고속도로의 길이 D(D <= 10,000 자연수)가 주어진다.
     * n개의 줄에 지름길의 시작, 도착, 길이 주어진다.
     * 
     * 문제 풀이
     * 최단거리를 묻는 문제
     * 다익스트라 풀이
     * 1. 간선들의 정보를 입력, 맵을 사용 Map <Integer, int[]> 시작점, [도착점, 거리]
     * 2. 다익스트라 알고리즘을 이용하여 거리를 갱신한다.
     * 
     * 13:30 => success
     */
    public static class route implements Comparable<route>{
        int end;
        int distance;
        public route(int end, int distance){
            this.end = end;
            this.distance = distance;
        }
        public int compareTo(route o){
            if(end == o.end){
                return distance - o.distance;
            }
            return end - o.distance;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Map<Integer, ArrayList<route>> map = new HashMap<>();
        int[] distance = new int[d + 1];
        for(int i = 0 ; i <= d; i++){
            distance[i] = 100000;
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if(map.containsKey(s)){
                ArrayList<route> now = map.get(s);
                now.add(new route(e, dist));
            }
            else{
                ArrayList<route> tmp = new ArrayList<>();
                route r = new route(e, dist) ;
                tmp.add(r);
                map.put(s, tmp);
            }
        }

        //다익스트라 부분
        PriorityQueue<route> pq = new PriorityQueue<>();
        pq.add(new route(0, 0));
        while(!pq.isEmpty()){
            route cur = pq.poll();
            int end = cur.end;
            int dist = cur.distance;
            if(end > d || dist > distance[end]){
                continue;
            }
            distance[end] = dist;
            if(map.get(end) != null){
                for(route c : map.get(end)){
                    pq.add(new route(c.end, dist + c.distance));
                }
            }
            pq.add(new route(end + 1, dist + 1));
        }
        System.out.println(distance[d]);
    }
}
