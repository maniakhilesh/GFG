class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] state = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                dfs(i, arr, state, result);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] == 1) {
                count++;
            }
        }

        return count;
    }

    private int dfs(int i, int[] arr, int[] state, int[] result) {
        int n = arr.length;

        if (i < 0 || i >= n) {
            return 1;
        }

        if (arr[i] == 0) {
            state[i] = 2;
            result[i] = 0;
            return 0;
        }

        if (state[i] == 1) {
            return 0; // Cycle detected
        }

        if (state[i] == 2) {
            return result[i];
        }

        state[i] = 1; // Currently visiting

        int next = i + arr[i];
        int good = dfs(next, arr, state, result);

        state[i] = 2;
        result[i] = good;

        return good;
    }
}