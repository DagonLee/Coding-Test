package boj.PriorityQueue;
import java.io.*;
import java.util.*;
public class boj21939 {
    /*
     * start 240210 11:15
     * 문제 
     * 3가지 명령이 존재
     * 1. recommend x
     *  x가 1인 경우 가장 어려운 문제 번호 출력
     *  x가 -1인 경우 가장 쉬운 문제 번호 출력
     * 2. add P L
     *  난이도 L인 문제번호 P를 추가
     * 3. solved P
     *  추천 문제 리스트에서 문제번호 P를 제거
     * 
     * 입력
     * 문제 개수 N
     * N개의 문제번호 P와 난이도 L이 주어진다.
     * M개의 명령문이 주어진다.
     * 
     * 해결방법
     * 1. 문제 클래스를 선언 난이도, 문제번호 순으로 정렬 되도록 (난이도, 문제번호 오름차순)
     * 2. Deque에 문제를 모두 삽입
     * 3. 명령어를 수행
     * 시간 초과 발생이 예상되어 방법 수정
     * 우선순위 큐를 내림차순, 오름차순 두개 사용
     * 모든 문제를 두 큐에 모두 삽입 후 사용
     * x가 1인 경우 내림차순 큐 사용
     * x가 -1인 경우 오름차순 큐 사용
     * 
     * 제거시에는 제거 리스트에 두고 사용
     * 
     * 24:24 failed 5 times
     * => 다시 풀기로 확정
     * 두번째 접근법으로 풀이 대신 문제별 난이도를 기록하는 맵을 사용하여 삭제 여부를 탐색한다.
     * => success
     */
    public static class Problem implements Comparable<Problem>{
        int difficulty;
        int num;
        Problem(int difficulty, int num){
            this.difficulty = difficulty;
            this.num = num;

        }
        public int compareTo(Problem o){
            if(difficulty == o.difficulty){
                return num - o.num;
            }
            return difficulty - o.difficulty;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue <Problem> ascendingPQ = new PriorityQueue<>();
        PriorityQueue <Problem> descendingPQ = new PriorityQueue<>(Collections.reverseOrder());
        Map <Integer, Integer> solvedMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            ascendingPQ.add(new Problem(l, p));
            descendingPQ.add(new Problem(l, p));
            solvedMap.put(p, l);
        }
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if(com.equals("add")){
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                ascendingPQ.add(new Problem(l, p));
                descendingPQ.add(new Problem(l, p));
                solvedMap.put(p, l);
            }
            else if(com.equals("recommend")){
                int x = Integer.parseInt(st.nextToken());
                if(x == 1){
                    Problem p;
                    while(true){
                        p = descendingPQ.poll();
                        if(p.difficulty == solvedMap.get(p.num)){
                            break;
                        }
                    }
                    sb.append(p.num + "\n");
                    descendingPQ.add(p);
                }
                else if(x == -1){
                    Problem p;
                    while(true){
                        p = ascendingPQ.poll();
                        if(p.difficulty == solvedMap.get(p.num)){
                            break;
                        }
                    }
                    sb.append(p.num + "\n");
                    ascendingPQ.add(p);
                }
            }
            else if(com.equals("solved")){
                int p = Integer.parseInt(st.nextToken());
                solvedMap.put(p, 0);
                // System.out.println("문제 번호 : " + p + " 삭제 여부" + solvedMap.get(p));
            }
        }
        System.out.println(sb.toString());
    }
}
