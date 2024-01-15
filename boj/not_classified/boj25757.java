package boj.not_classified;

import java.io.*;
import java.util.*;
public class boj25757 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 신청한 사람을 중복을 제거하여 식별
        // 2. 신청한 총 인원 수를 를게임 종류에 따라 필요한 인원으로 나누어 반환
        // ex) Y 는 임스를 제외하고 1명 필요하므로 1명으로 나눈다.
        //      F는 임스를 제외하고 2명 필요하므로 2명으로 나눈다.

        int n = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        int mod = 0;
        if(c == 'Y'){
            mod = 1;
        }
        else if(c == 'F'){
            mod = 2;
        }
        else if(c == 'O'){
            mod = 3;
        }
        HashSet <String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }
        System.out.println(set.size() / mod);
    }
}
