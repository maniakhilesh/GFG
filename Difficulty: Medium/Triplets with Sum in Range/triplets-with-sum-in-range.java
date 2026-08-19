class Solution {

    public int countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);

        return countLessOrEqual(arr, r) - countLessOrEqual(arr, l - 1);
    }

    private int countLessOrEqual(int[] arr, int target) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum <= target) {
                    // Every element from j+1 to k
                    // can form a valid triplet with i and j
                    count += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }
}