class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;
        long total = 1L * n * (n - 1) / 2;
        HashMap<Integer, Integer> mp = new HashMap<>((int) (total / 0.7) + 16, 0.7f);

        int[] ans = {-1, -1, -1, -1};

        // Generate all pairs in lexicographical order.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];

                Integer first = mp.get(sum);
                if (first == null) {
                    // Store only the first pair for each sum (encoded as a * 1000 + b).
                    mp.put(sum, i * 1000 + j);
                } else {
                    int a = first / 1000, b = first % 1000;

                    // Check whether all four indices are distinct.
                    if (a != i && a != j && b != i && b != j) {
                        // Keep the lexicographically smallest answer.
                        if (ans[0] == -1 || smaller(a, b, i, j, ans)) {
                            ans[0] = a;
                            ans[1] = b;
                            ans[2] = i;
                            ans[3] = j;
                        }
                    }
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>(4);
        for (int x : ans) {
            res.add(x);
        }
        return res;
    }

    private boolean smaller(int a, int b, int c, int d, int[] best) {
        if (a != best[0]) return a < best[0];
        if (b != best[1]) return b < best[1];
        if (c != best[2]) return c < best[2];
        return d < best[3];
    }
}