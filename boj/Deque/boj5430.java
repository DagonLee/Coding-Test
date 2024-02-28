package boj.Deque;
import java.io.*;
import java.util.*;
public class boj5430 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            char[] com = br.readLine().toCharArray();
            boolean reversed = false;
            int n = Integer.parseInt(br.readLine());
            String nums = br.readLine();
            String[] data = nums.substring(1, nums.length() - 1).split(",");
            Deque<Integer> dq = new ArrayDeque<>();
            if(n == 0){
            }
            else{
                if(data.length == 1){
                    String one = nums.substring(1, nums.length() - 1);
                    dq.addLast(Integer.parseInt(one));
                }
                else{
                    for (String str : data) {
                        dq.addLast(Integer.parseInt(str));
                    }
                }
            }
            boolean printed = false;
            for(char c: com){
                if(c == 'R'){
                    if(reversed){
                        reversed = false;
                    }
                    else{
                        reversed = true;
                    }
                }
                else{
                    if(dq.isEmpty()){
                        printed = true;
                        break;
                    }

                    if(reversed){
                        n --;
                        dq.pollLast();
                    }
                    else{
                        n--;
                        dq.pollFirst();
                    }
                }
            }
            
            if (printed) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!dq.isEmpty()) {
                    if (reversed) {
                        sb.append(dq.pollLast());
                    } else {
                        sb.append(dq.pollFirst());
                    }
                    if (!dq.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
}
