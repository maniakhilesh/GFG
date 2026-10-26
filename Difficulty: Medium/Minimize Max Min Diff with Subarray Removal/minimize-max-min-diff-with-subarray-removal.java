class Solution {
    public int minDiff(int k, int[] arr) {
        int n = arr.length;

        if (k == 0) {
            int min = arr[0];
            int max = arr[0];

            for (int x : arr) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }

            return max - min;
        }

        int[] prefixMin = new int[n];
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        int[] suffixMax = new int[n];

        prefixMin[0] = prefixMax[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], arr[i]);
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        suffixMin[n - 1] = suffixMax[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int start = 0; start <= n - k; start++) {
            int end = start + k - 1;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            if (start > 0) {
                min = Math.min(min, prefixMin[start - 1]);
                max = Math.max(max, prefixMax[start - 1]);
            }

            if (end < n - 1) {
                min = Math.min(min, suffixMin[end + 1]);
                max = Math.max(max, suffixMax[end + 1]);
            }

            ans = Math.min(ans, max - min);
        }

        return ans;
    }
}