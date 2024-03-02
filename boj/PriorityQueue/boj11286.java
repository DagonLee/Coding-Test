package boj.PriorityQueue;

import java.io.*;
import java.util.*;
public class boj11286{
    /*
     * 문제
     * 주어진 값 만큼 값을 저장하거나 절댓값이 가장 작은 값을 가지고 오는 연산을 한다.
     * 
     * 해결방법
     * 우선순위 큐에 값에 대한 절댓값을 넣으면서 값, 빈도수를 저장하는 맵에 저장
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(br.readLine());
            if(val != 0){
                pq.add(Math.abs(val));
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
            else{
                if(pq.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    int cur = pq.poll();
                    if(map.containsKey(-cur)){
                        if(map.get(-cur) == 1){
                            map.remove(-cur);
                        }
                        else{
                            map.put(-cur, map.get(-cur) - 1);
                        }
                        sb.append(-cur + "\n");

                    }
                    else if(map.containsKey(cur)){
                        if(map.get(cur) == 1){
                            map.remove(cur);
                        }
                        else{
                            map.put(cur, map.get(cur) - 1);
                        }
                        sb.append(cur + "\n");
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}