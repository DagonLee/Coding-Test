package boj.Graph;

import java.io.*;
import java.util.*;

public class boj2660 {
    /*
     * start 240319 16:13
     * 문제
     * 사람들의 번호와 연결 여부가 주어진다.
     * 모든 사람들이 연결되어있으며, 각 사람 별로 최대 연결 길이가 그 사람의 점수가 된다.
     * ex) 한 회원의 점수가 1점 => 모든 회원이 이 회원과 연결
     *     한 회원의 점수가 2점 => 모든 회원이 이 회원과 연결되어 있거나 연결된 회원과 연결되어있다.
     *     한 회원의 점수가 3점 => 모든 회원이 이 회원과 연결되어 있거나 연결된 회원과 연결되어 있거나 또는 연결된 회원과 연결
     * 해결방법
     * BFS로 각 회원 별 점수를 계산
     * 점수가 가장 작은 회원을 넣어두고 출력
     * success = > 16:43
     */
    static int n;
    public static int calculateScore(ArrayList<Integer>[] adj, int start){
        ArrayDeque <int[]> q = new ArrayDeque<>();
        int[] checked = new int[n + 1];
        Arrays.fill(checked, -1);
        checked[start] = 0;
        q.add(new int[] {start, 0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int nxt : adj[now[0]]){
                if(checked[nxt] == -1){
                    checked[nxt] = now[1] + 1;
                    q.add(new int[]{nxt, checked[nxt]});
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(i == start){
                continue;
            }
            max = Math.max(max, checked[i]);
        }
        return max;
    }
    static class member implements Comparable<member>{
        int num;
        int score;
        member(int num, int score){
            this.num = num;
            this.score = score;
        }
        public int compareTo(member o){
            if(o.score == this.score){
                return num - o.num;
            }
            return score - o.score;
        }
        public void print(){
            System.out.println("num : " + num + " score : " + score);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1){
                break;
            }
            adj[a].add(b);
            adj[b].add(a);
        }
        ArrayList<member> lst = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            int score = calculateScore(adj, i);
            lst.add(new member(i, score));
        }
        
        Collections.sort(lst);
        int maxScore = lst.get(0).score;
        int headCnt = 0;
        for(member now : lst){
            if(now.score == maxScore){
                headCnt ++;
            }
        }
        System.out.println(maxScore + " " + headCnt);
        for(member now: lst){
            if(now.score == maxScore){
                System.out.print(now.num + " ");
            }
            else{
                break;
            }
        }
    }
}
