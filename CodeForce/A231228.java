package CodeForce;
import java.io.*;
import java.util.*;
public class A231228 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a != b){
                if(a != c){
                    System.out.println(a);
                }
                else{
                    System.out.println(b);
                }
            }
            else{
                System.out.println(c);
            }
        }
    }
}
