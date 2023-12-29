package CodeForce;
import java.io.*;
import java.util.*;
public class C231228 {
    static boolean isSquare(long num){
        if(Math.pow((int)Math.sqrt(num), 2) == num){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            long sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                sum += Integer.parseInt(st.nextToken());
            }
            
            if(isSquare(sum)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }    
}
