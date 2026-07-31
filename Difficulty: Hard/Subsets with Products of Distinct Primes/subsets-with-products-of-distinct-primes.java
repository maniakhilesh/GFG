class Solution {

    public int countSubsets(int[] arr) {

    

        long MOD = 1000000007;

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        

        // Count frequencies of each number up to 30

        int[] count = new int[31];

        for (int num : arr) {

            if (num <= 30) {

                count[num]++;

            }

        }

        

        // Precompute masks for numbers 2 to 30

        int[] masks = new int[31];

        for (int i = 2; i <= 30; i++) {

            int temp = i;

            int mask = 0;

            boolean isValid = true;

            

            for (int j = 0; j < 10; j++) {

                int p = primes[j];

                if (temp % p == 0) {

                    temp /= p;

                    // If divisible again, it contains a square factor (e.g., 4, 9)

                    if (temp % p == 0) {

                        isValid = false;

                        break;

                    }

                    mask |= (1 << j);

                }

            }

            if (isValid) {

                masks[i] = mask;

            } else {

                masks[i] = -1; // Mark as invalid

            }

        }

        

        // dp[mask] stores the number of valid subsets with prime product representation = mask

        long[] dp = new long[1024];

        dp[0] = 1; // Base case: empty subset

        

        // Form subsets using numbers from 2 to 30

        for (int i = 2; i <= 30; i++) {

            if (count[i] == 0 || masks[i] == -1) continue;

            

            int maskX = masks[i];

            // Iterate backwards to avoid using the same element multiple times

            for (int mask = 1023; mask >= 0; mask--) {

                if ((mask & maskX) == 0) { // No common prime factors

                    dp[mask | maskX] = (dp[mask | maskX] + dp[mask] * count[i]) % MOD;

                }

            }

        }

        

        // Sum up all subsets with at least one prime factor (mask > 0)

        long ans = 0;

        for (int mask = 1; mask < 1024; mask++) {

            ans = (ans + dp[mask]) % MOD;

        }

        

        // Multiply by 2^(count of 1s) because each '1' can be included or excluded

        for (int i = 0; i < count[1]; i++) {

            ans = (ans * 2) % MOD;

        }

        

        return (int) ans;

    }

}