package CodeForce;
import java.io.*;
import java.util.*;
public class E231228 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t = 0; t < n; t++){
            int c = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean printed = false;
            long even = 0;
            long odd = 0;
            for(int i = 0; i < c; i++){
                if(i % 2 == 0){
                    even += Integer.parseInt(st.nextToken());
                }
                else{
                    odd += Integer.parseInt(st.nextToken());
                }
                if(even == odd){
                    System.out.println("YES");
                    printed = true;
                    break;
                }
            }
            if(!printed){
                System.out.println("NO");
            }
        }
    }
}
