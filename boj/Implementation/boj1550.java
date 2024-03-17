package boj.Implementation;
import java.io.*;

public class boj1550{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int cnt = 0;
        int ans = 0;
        for(int i = (input.length - 1);  i >= 0; i--){
            double val = Math.pow(16, cnt);
            int cal = 0;
            if(input[i] >= '0' && input[i] <= '9'){
                cal += (input[i] -'0');
            }
            else{
                cal += 10;
                cal += (input[i] - 'A');
            }
            cnt++;
            ans += (cal * val);
        }
        System.out.println(ans);
    }
}