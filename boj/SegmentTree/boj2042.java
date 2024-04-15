package boj.SegmentTree;

import java.io.*;
import java.util.*;

public class boj2042 {
    static Long[] arr;
    static int n;
    static Long[] tree;
    static Long init(int start, int end, int node){
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static Long sum(int start, int end, int node, int left, int right){
        if(left > end || right < start) return 0L;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int index, Long diff){
        if(index < start || index > end) return;
        tree[node] += diff;
        if(start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        tree = new Long[n * 4];
        arr = new Long[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        init(1, n, 1);
        for(int i = 0; i < (m + k); i++){
            st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Long c = Long.parseLong(st.nextToken());
            if(com == 1){
                update(1, n, 1, b, c - arr[b]);
                arr[b] = c;
            }
            else if(com == 2){
                sb.append(sum(1, n, 1, b, c.intValue()) + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
