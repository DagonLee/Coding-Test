package boj.Implementation;

import java.io.*;
import java.util.*;

public class boj1713 {
    static class Student implements Comparable<Student>{
        int num;
        int liked;
        int time;
        Student(int num, int liked, int time){
            this.num = num;
            this.liked = liked;
            this.time = time;
        }
        public int compareTo(Student o){
            if(this.liked == o.liked){
                return this.time - o.time;
            }
            return this.liked - o.liked;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Student> pictures = new ArrayList<>();
        for(int i = 1; i <= T; i++){
            int num = Integer.parseInt(st.nextToken());
            boolean pictured = false;
            for(Student cur : pictures){
                if(cur.num == num){
                    cur.liked ++;
                    pictured = true;
                    break;
                }
            }
            if(!pictured){
                if(pictures.size() == n){
                    Collections.sort(pictures);
                    pictures.remove(0);
                }
                pictures.add(new Student(num, 1, i));
            }
            // for(Student cur : pictures){
            //     System.out.println("번호 : " + cur.num + " 추천 : " + cur.liked + " 추가 시간 : " + cur.time);
            // }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Student cur : pictures){
            ans.add(cur.num);
        }
        Collections.sort(ans);
        for(int num : ans){
            System.out.print(num + " ");
        }

    }
}
