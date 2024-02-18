package boj.Implementation;
import java.io.*;
import java.util.*;
public class boj1620 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String[] names = new String[n + 1];
        Map<String, Integer> book = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String name = br.readLine();
            book.put(name, i);
            names[i] = name;
        }
        for(int i = 1; i <= m; i++){
            String val = br.readLine();
            if(book.containsKey(val)){
                System.out.println(book.get(val));
            }
            else{
                System.out.println(names[Integer.parseInt(val)]);
            }
        }
    }
}
