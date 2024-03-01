package boj.Implementation;
import java.io.*;
import java.util.StringTokenizer;
public class boj1541 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
        boolean isMinus = false;
        long tmp = 0;
        while(st.hasMoreTokens()){
            String cur = st.nextToken();
            if(cur.equals("+")){
                if(isMinus){
                    sum -= tmp;
                    tmp = 0;
                }
            }
            else if(cur.equals("-")){
                if(!isMinus){
                    isMinus = true;
                }
            }
            else{
                int val = Integer.parseInt(cur);
                if(isMinus){
                    tmp += val;
                }
                else{
                    sum += val;
                }
            }
        }
        if(tmp != 0){
            sum -= tmp;
            tmp = 0;
        }
        System.out.println(sum);
    }
}
