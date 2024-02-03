package boj.PriorityQueue;
import java.io.*;
import java.util.*;
public class boj1927 {
    /*
     * start 240203 11:30
     * 문제
     * n개의 연산
     * 연산에 대한 정보 x
     * x가 자연수 => x 값 추가
     * x가 0 => 최솟 값 반환 후 제거
     * 해결 방법
     * 우선순위 큐 사용
     * end 11:37
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()+"\n");
                }
                else{
                    sb.append("0\n");
                }
            }
            else{
                pq.add(val);
            }
        }
        System.out.println(sb.toString());
    }
}
