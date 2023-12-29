package CodeForce;
import java.io.*;
import java.util.*;
public class B231228 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t = 0; t < n; t++){
            int a_cnt = 0;
            int b_cnt = 0;
            int c_cnt = 0;
            for(int i = 0; i < 3; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String line = st.nextToken();

                for(int j = 0; j < 3; j++){
                    char c = line.charAt(j);
                    if(c =='A'){
                        a_cnt ++;
                    }
                    else if(c =='B'){
                        b_cnt++;
                    }
                    else if(c == 'C'){
                        c_cnt++;
                    }
                }
                
                
            }
            if(a_cnt != 3){
                    System.out.println("A");
            }
            else if(b_cnt != 3){
                System.out.println("B");
            }
            else if(c_cnt != 3){
                System.out.println("C");
            }
        }
    }
}
