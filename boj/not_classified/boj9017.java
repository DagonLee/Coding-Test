package boj.not_classified;
import java.io.*;
import java.util.*;
public class boj9017 {
    public static void main(String[] args) throws Exception{
        // 검사해야할 항목
        // 1. 팀당 여섯 6명의 선수가 있는지
        // 2. 동점인 경우에는 다섯번째 선수의 번호가 낮으면 성공

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map <Integer, Integer> num_cnt = new HashMap<>();
            ArrayList<Integer> nums = new ArrayList<>();
            Map<Integer, ArrayList> map = new HashMap<>();
            for(int j = 1; j <= n; j++){
                int num = Integer.parseInt(st.nextToken());
                nums.add(num);
                num_cnt.put(num, num_cnt.getOrDefault(num, 0) + 1);
            }
            int idx = 0;
            for(int j = 0; j < n; j++){
                if(num_cnt.get(nums.get(j)) >= 6){
                    if(map.containsKey(nums.get(j))){
                        map.get(nums.get(j)).add(idx);
                    }
                    else{
                        ArrayList<Integer> lst = new ArrayList<>();
                        lst.add(idx);
                        map.put(nums.get(j), lst);
                    }
                    idx++;
                }
            }
            int sum = 6000;
            int team = -1;
            int fifth = 0;
            for(int num : map.keySet()){
                if(map.get(num).size() >= 6){
                    ArrayList <Integer> lst = map.get(num);
                    int tmp_sum = 0;
                    int tmp_fifth = 0;
                    for(int k = 0; k < 4; k++){
                        tmp_sum += lst.get(k);
                    }
                    tmp_fifth = lst.get(4);
                    if(tmp_sum < sum){
                        team = num;
                        fifth = tmp_fifth;
                        sum = tmp_sum;
                    }
                    else if(tmp_sum == sum){
                        if(tmp_fifth < fifth){
                            team = num;
                            fifth = tmp_fifth;
                        }
                    }
                }
            }
            sb.append(team+"\n");
        }
        System.out.println(sb.toString());
    }
}
