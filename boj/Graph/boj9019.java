package boj.Graph;

import java.util.*;

class State {
    int value;
    String path;

    public State(int value, String path) {
        this.value = value;
        this.path = path;
    }
}

public class boj9019 {
    public static void bfs(int start, int target) {
        boolean[] visited = new boolean[10000];
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(start, ""));

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int curValue = current.value;
            String curPath = current.path;

            if (curValue == target) {
                System.out.println(curPath);
                return;
            }

            // D 연산
            int nxt1 = (curValue * 2) % 10000;
            if (!visited[nxt1]) {
                visited[nxt1] = true;
                queue.offer(new State(nxt1, curPath + "D"));
            }

            // S 연산
            int nxt2 = (curValue - 1 + 10000) % 10000;
            if (!visited[nxt2]) {
                visited[nxt2] = true;
                queue.offer(new State(nxt2, curPath + "S"));
            }

            // L 연산
            int lnum = ((curValue % 1000) * 10) + (curValue / 1000);
            if (!visited[lnum]) {
                visited[lnum] = true;
                queue.offer(new State(lnum, curPath + "L"));
            }

            // R 연산
            int rnum = ((curValue % 10) * 1000) + (curValue / 10);
            if (!visited[rnum]) {
                visited[rnum] = true;
                queue.offer(new State(rnum, curPath + "R"));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            bfs(A, B);
        }
    }
}