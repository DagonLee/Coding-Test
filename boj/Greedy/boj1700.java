package boj.Greedy;

import java.io.*;
import java.util.*;
public class boj1700 {
    /*
     * 240219 12:19
     * 문제
     * 멀티탭에서 플러그를 빼는 횟수를 최소화하여 사용하고자한다.
     * 
     * 입력
     * 멀티탬 구멍 수 : n
     * 전기 용품 사용횟수: k
     * 전기용품 이름이 k이하의 자연수로 주어진다.
     * 
     * 해결방법
     * 멀티탭 리스트를 정의
     * 용품별 등장 시점 리스트를 정의
     * 전기용품 입력을 모두 저장하면서, 각 용품의 등장 시점을 저장
     * 
     * 다시 전기용품 입력을 모두 순회,
     * 멀티탭 리스트에 자리가 있다면 현재 용품을 추가
     * 추가시 각 용품의 등장 시점 큐에서 값을 하나 제거하여 등장 시점 큐 갱신
     * 자리가 없다면 멀티탭 리스트 안에서 다음에 가장 늦게 등장할 용품을 찾아서 대체
     * 대체 될 용품 찾는 절차
     * int nextAppear, id;
     * 1. 멀티탭에 있는 모든 용품별 등장 큐에 다음에 등장 할 시점을 구하라
     * 2. nextAppear 보다 큰 경우 id와 nextAppear을 교체
     * 
     * 데이터
     * ArrayList<Integer> multi // 현재 멀티탭 상태
     * Deque<Integer>[] appearList // 용품별 등장 시점 큐
     * 
     * 12:56 => fail 가장 update가 느린 값으로 교체한 전략
     * 13:19 => success, 질문 게시판의 반례를 참고하여 해결
     * 이미 멀티탭에 있는 경우, 등장 appearList에서 제거하지 않아서 생기는 오류
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> multi = new ArrayList<>();
        Deque<Integer>[] appearList = new Deque[k + 1];
        ArrayList<Integer> data = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i <= k; i++){
            appearList[i] = new ArrayDeque<>();
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i ++){
            int val = Integer.parseInt(st.nextToken());
            appearList[val].offerLast(i);
            data.add(val);
        }
        for(int d : data){
            if(multi.contains(d)){
                appearList[d].pollFirst();
                continue;
            }
            if(multi.size() == n){
                //대체 될 용품 탐색
                int nextAppear = -1;
                int idx = 0;
                for(int i = 0; i < multi.size(); i++){
                    int cur = multi.get(i);
                    if(appearList[cur].size() == 0){
                        nextAppear = Integer.MAX_VALUE;
                        idx = i;
                    }
                    else if(appearList[cur].getFirst() > nextAppear){
                        nextAppear = appearList[cur].getFirst();
                        idx = i;
                    }
                }
                multi.remove(idx);
                cnt ++;
            }
            
            multi.add(d);

            // System.out.print("등장: " + d + multi.toString()+" " + cnt);
            // System.out.println();
            appearList[d].pollFirst();
        }
        System.out.println(cnt);
        
    }
}
