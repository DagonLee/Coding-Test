package boj.Implementation;

import java.io.*;
import java.util.*;
public class boj20006 {
    /*
     * start 240203 11:40
     * 문제
     * 게임 매칭
     * 1. 매칭 가능한 유저 없다면 방 생성(생성 유저 기준 +- 10 레벨의 플레이어 입장 가능)
     * 2. 입장 가능한 방이 있다면 정원이 찰때까지 입장 후 대기
     * 
     * 알아야할 방 정보
     * 1. 방의 입장 가능 기준 레벨
     * 2. 방의 현재 인원 리스트 
     * 3. 방의 제한 인원
     * 
     * 시도
     * 1 ~ 3rd try => fail, limit 이 1인 경우 고려하지 않음
     * 4th try: limit이 1인 경우 고려하여 해결
     * end 12:18
     */
    static int limit;
    public static class User implements Comparable<User>{
        int level;
        String id;
        User(int level, String id){
            this.level = level;
            this.id = id;
        }
        public void print(){
            System.out.println("id : " + id);
            System.out.println("level : " + level);
        }
        @Override
        public int compareTo(User o) {
            return id.compareTo(o.id);
        }

    }
    public static class Room{
        int level; //레벨 기준
        int curCnt;// 현재 인원수
        ArrayList<User> part; //참가자 리스튼
        boolean started; // 시작 여부
Room(int level, String first){
            this.level = level;
            part = new ArrayList<>();
            part.add(new User(level, first));
            curCnt = 1;
            if(curCnt == limit){
                started = true;
            }
            else{
                started = false;
            }
        }
        public boolean add(String person, int curLevel){
            if(Math.abs(curLevel - level) <= 10 && curCnt + 1 <= limit){
                part.add(new User(curLevel, person));
                curCnt++;
                if(curCnt == limit){
                    started = true;
                }
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Room> roomList = new ArrayList<>();
        int p; //플레이어 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            int curLevel = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            boolean added = false;
            for(Room r : roomList){
                if(r.add(id, curLevel)){
                    added = true;
                    break;
                }
            }
            if(!added){
                Room newRoom = new Room(curLevel, id);
                roomList.add(newRoom);
            }
        }
        for(Room r : roomList){
            Collections.sort(r.part);
            if(r.started){
                System.out.println("Started!");
            }
            else{
                System.out.println("Waiting!");
            }
            for(User u : r.part){
                System.out.println(u.level + " " + u.id);
            }
        }
    }
}
