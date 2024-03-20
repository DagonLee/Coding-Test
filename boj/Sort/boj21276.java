package boj.Sort;

import java.io.*;
import java.util.*;

public class boj21276 {
    /*
     * start 240320 09:27
     * 문제
     * n명의 사람들이 존재, n명의 사람들은 모두 자신의 조상을 알고 있다.
     * 트리 형태의 족보를 구성하려고 할때, 각 가문의 시조들의 이름을 공백으로 구분하여 사전순 출력
     * 이름 사전 순으로 이름과 자식 수, 그리고 자식들의 이름을 공백으로 구분하여 출력
     * 부분문제 해결 10/19
     */
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] people = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        Map<String, ArrayList<String>> map = new HashMap<>();
        Map<String, Integer> deg = new HashMap<>();
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            String ancestor = st.nextToken();
            deg.put(p, deg.getOrDefault(p, 0) + 1);
            if(map.containsKey(ancestor)){
                ArrayList<String> tmp = map.get(ancestor);
                tmp.add(p);
                map.put(ancestor, tmp);
            }
            else{
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(p);
                map.put(ancestor, tmp);
            }
        }
        ArrayList<String> heads = new ArrayList<>();
        Arrays.sort(people);
        for(String person : people){
            if(!deg.containsKey(person)){
                heads.add(person);
            }
        }
        Collections.sort(heads);
        System.out.println(heads.size());
        for(String head : heads){
            System.out.print(head + " ");
        }
        System.out.println();
        Map<String, ArrayList<String>> ans = new HashMap<>();
        for(String person : people){
            int cur = deg.getOrDefault(person, 0);
            if(map.containsKey(person)){
                for(String nxt: map.get(person)){
                    int nxtDeg = deg.get(nxt);
                    if((nxtDeg - cur) == 1){
                        if(ans.containsKey(person)){
                            ArrayList<String> tmp = ans.get(person);
                            tmp.add(nxt);
                            ans.put(person, tmp);
                        }
                        else{
                            ArrayList<String> tmp = new ArrayList<>();
                            tmp.add(nxt);
                            ans.put(person, tmp);
                        }
                    }
                }
            }
        }
        for(String person : people){
            if(ans.containsKey(person)){
                ArrayList<String> childs = ans.get(person);
                System.out.print(person + " ");
                System.out.print(childs.size() + " ");
                for(String child : childs){
                    System.out.print(child + " ");
                }
            }
            else{
                System.out.print(person + " ");
                System.out.print(0);
            }
            System.out.println();
        }
    }
}
