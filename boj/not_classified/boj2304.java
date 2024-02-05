package boj.not_classified;

import java.io.*;
import java.util.*;

public class boj2304 {
    /*
     * start 240205 17:11
     * 문제
     * 기둥의 개수 n,
     * 기둥의 위치 L, 높이 H
     * 기둥을 덮는 지붕의 면적을 구하시오
     * 단 규칙은 다음과 같음
     * 1. 지붕은 수평 부분과 수직 부분으로 구성되며, 모두 연결되어야 한다.
     * 2. 지붕의 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 한다.
     * 3. 지붕의 수직 부분은 반드시 어떤 기둥의 옆면과 닿아야 한다.
     * 4. 지붕의 가장자리는 땅에 닿아야 한다.
     * 5. 비가 올 때 물이 고이지 않도록 지붕의 어떤 부분도 오목하게 들어간 부분이 없어야 한다.
     * 
     * 해결방법
     * 면접 = 가장 긴 기둥 * 2 + (마지막 기둥 위치 - 처음 시작 된 기둥 위치)
     * 17:24 길이로 잘못 이해
     * 면적으로 다시 해결방법 탐색
     * 17:30 
     * 1. 기둥들을 클래스로 선언 위치로 정렬
     * 2. 루프를 돌면서 가장 큰 기둥을 기준으로 분할, 가장 큰 기둥의 인덱스를 p 라고 함
     * 3. 0번 인덱스를 시작으로 p 기둥 이전 까지 이전 보다 큰 기둥이 나오는 경우 면적 누적을 갱신
     * 4. p 인덱스 이후의 기둥들에 대해서는 역방향으로 3번을 과정을 진행
     * 
     *1st try fail => 반례 찾음, 
     * 가장 긴 높이가 여러개인 경우 오류
     * 2nd,3rd try fail
     * 4th try => success 18:12
     * 인덱스 착오로 인한 실수, left_p, right_p 를 사용할때는 beamList에서 position을 가져와야하는데 
     * left_p, right_p를 그대로 사용한 실수
     */
    public static class Beam implements Comparable<Beam> {
        int position;//위치
        int height; // 높이;
        Beam(int position, int height){
            this.position = position;
            this.height = height;
        }
        @Override
        public int compareTo(Beam o) {
            return position - o.position;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Beam>beamList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            Beam b = new Beam(l, h);
            beamList.add(b);
        }
        Collections.sort(beamList);
        int left_highest = 0;
        int left_p = 0;

        for(int i = 0; i < beamList.size(); i++){
            if(left_highest < beamList.get(i).height){
                left_highest = beamList.get(i).height;
                left_p = i;
            }
        }

        int right_p = 0;
        for(int i = beamList.size() - 1; i >= 0; i--){
            if(left_highest == beamList.get(i).height){
                right_p = i;     
                break;           
            }
        }

        int curPos = beamList.get(0).position;
        int height = beamList.get(0).height;
        int ans = 0;
        for(int i = 1; i <= left_p; i++){
            if(beamList.get(i).height > height){
                ans += (beamList.get(i).position - curPos) * height;
                height = beamList.get(i).height;
                curPos = beamList.get(i).position;
            }
        }
        // System.out.println(left_p + " " + right_p);
        if(left_p == right_p){
            ans += left_highest;
        }
        else{
            ans += ((beamList.get(right_p).position - beamList.get(left_p).position) + 1) * left_highest;
        }

        curPos = beamList.get(beamList.size() - 1).position;
        height = beamList.get(beamList.size() - 1).height;
        for(int i = beamList.size() - 2; i >= right_p; i--){
            if(beamList.get(i).height > height){
                ans += (curPos - beamList.get(i).position) * height;
                height = beamList.get(i).height;
                curPos = beamList.get(i).position;
            }
        }
        System.out.println(ans);
    }
}
