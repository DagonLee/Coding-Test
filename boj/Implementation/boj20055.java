package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj20055 {
    /*
     * start 240212 15:24
     * 
     * 문제
     * 길이가 2n 인 벨트가 돌고 있다.
     * 위 아래로 n길이이며 회전한다.
     * 올리는 위치는 1, 내리는 위치는 n
     * 언제든 내리는 위치에 오는 로봇은 즉시제거
     * 벨트가 회전하면서 이동, 1 ~ 2n - 1은 다음 칸으로 2n번 칸은 1로
     * 
     * 로봇 이동 과정
     * 1. 벨트 회전, 로봇과 함께
     * 2. 가장 먼저 벨트에 올라간 로봇 부터 이동
     * 3. 올리는 위치에 로봇 올린다.( 단, 올리는 칸의 내구도는 0이 아니어야한다.)
     * 4. 내구도 0인 칸의 개수 K개 이상이라면 과정 종료
     * 
     * 해결방법
     * 벨트 클래스, 벨트 내구도, 로봇 존재 여부
     * 벨트 리스트
     * 로봇 리스트, 현재 위치
     * 
     * 1. 벨트 회전
     *  모든 로봇 위치 + 1, 벨트 리스트 들 이동
     *  n번 위치 확인 후 로봇 제거
     * 2. 로봇 리스트를 순회하여 로봇 이동
     *  로봇 여부, 내구도 1이상 확인
     * 3. 벨트 0번 인덱스 확인하여 내구도 0 이상시 로봇추가
     *  벨트 리스트, 로봇 리스트 갱신
     * 4. 내구도 확인하여 종료 여부 확인,
     *  아니라면 단계 + 1하고 계속
     * 
     * 16:13 1차 구현 완료
     * 16:35 모든 예제 통과 => success
     */
    public static class Block{
        int life;
        boolean hasRobot;
        public Block(int life, boolean hasRobot){
            this.life = life;
            this.hasRobot = hasRobot;
        }
    }
    public static int n;
    public static int k;
    public static Block[] belt;
    public static ArrayList<Integer> robots;
    public static void rotate(){//벨트 회전
        //삭제 여부
        boolean hasDelete = false;
        int delIdx = -1;

        // 벨트 리스트 이동
        Block tmp = belt[2 * n - 1];
        for(int i = 2 * n - 1; i >= 1; i --){
            belt[i] = belt[i - 1];
        }
        belt[0] = tmp;
        for(int i = 0; i < robots.size(); i ++){
            int next = (robots.get(i) + 1) % (2 * n);
            robots.set(i, next);
            if(robots.get(i) == n - 1){
                delIdx = i;
                hasDelete = true;
            }
        }
        if(hasDelete){
            robots.remove(delIdx);
        }
        belt[n - 1].hasRobot = false;
    }
    public static void move(){//로봇 이동
        //삭제 여부
        boolean hasDelete = false;
        int delIdx = -1;
        for(int i = 0; i < robots.size(); i ++){
            int cur = robots.get(i);
            int next = (robots.get(i) + 1) % (2 * n);
            if(belt[next].life > 0 && !belt[next].hasRobot){
                belt[cur].hasRobot = false;
                robots.set(i, next);
                belt[next].life --;
                belt[next].hasRobot = true;
                if(robots.get(i) == n - 1){
                    delIdx = i;
                    hasDelete = true;
                }
                
            }
        }
        if(hasDelete){
            robots.remove(delIdx);
            belt[n - 1].hasRobot = false;
        }
    }
    public static void addRobot(){
        if(belt[0].life > 0 && !belt[0].hasRobot){
            belt[0].life --;
            belt[0].hasRobot = true;
            robots.add(0);
        }
    }
    public static boolean canStop(){// 종료 여부 확인
        int cnt = 0;
        for(int i = 0; i < 2 * n; i++){
            if(belt[i].life == 0){
                cnt++;
            }
        }
        if(cnt >= k){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new Block[2 * n];
        robots = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * n; i++){
            int life = Integer.parseInt(st.nextToken());
            belt[i] = new Block(life, false);
        }
        int level = 1;
        while(true){
            rotate();
            move();
            addRobot();
            if(canStop()){
                break;
            }
            level++;
        }
        System.out.println(level);
    }
}
