package boj.BinarySearch;

import java.util.*;

public class boj3151 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[10002];

        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();
        
        Arrays.sort(a, 0, n);

        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = -a[i] - a[j];
                int ub = upperBound(a, j + 1, n, target);
                int lb = lowerBound(a, j + 1, n, target);
                ans += (ub - lb + 1);
            }
        }
        System.out.println(ans);
    }

    private static int upperBound(int[] arr, int low, int high, int key) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= key)
                low = mid + 1;
            else
                high = mid;
        }
        return low - 1;
    }

    private static int lowerBound(int[] arr, int low, int high, int key) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
