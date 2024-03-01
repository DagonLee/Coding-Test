package boj.Greedy;
import java.io.*;
public class boj3687 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] dp = new String[101];
        int T = Integer.parseInt(br.readLine());
        dp[2] = "1";
        dp[3] = "7";
        dp[4] = "4";
        dp[5] = "2";
        dp[6] = "6";
        dp[7] = "8";
        for(int i = 8; i <= 100; i++){
            long val = Long.MAX_VALUE;
            for(int j = 2; j <= 7; j++){
                if(i - j >= 2){
                    String tmp = dp[i - j];
                    if(j == 6){
                        tmp += "0";
                    }
                    else{
                        tmp += dp[j];
                    }
                    long tmpVal = Long.parseLong(tmp);
                    if(val > tmpVal){
                        val = tmpVal;
                    }
                }
            }
            dp[i] = Long.toString(val);
        }
        for(int tc = 1; tc <= T; tc++){
            int n = Integer.parseInt(br.readLine());
            String val = "";
            if(n % 2 == 0){
                int len = (n / 2);
                for(int i = 0; i < len ;i++){
                    val += "1";
                }
            }
            else{
                int len = (n / 2) - 1;
                val += "7";
                for(int i = 0; i < len; i++){
                    val += "1";
                }
            }
            sb.append(dp[n] + " " + val + "\n");
        }
        System.out.println(sb.toString());
    }
}
