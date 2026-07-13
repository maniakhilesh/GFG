class Solution {

    int minOperations(int[] b) {

        

        int n = b.length;

        boolean[] visited = new boolean[n];

        long MOD = 1000000007L;

        

        // Map to keep track of the maximum power of each prime factor needed

        Map<Integer, Integer> maxPrimePowers = new HashMap<>();

        

        // Find all cycle lengths

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                int cycleLength = 0;

                int curr = i;

                

                // Traverse the cycle

                while (!visited[curr]) {

                    visited[curr] = true;

                    // b[] is 1-indexed, so convert to 0-indexed position

                    curr = b[curr] - 1; 

                    cycleLength++;

                }

                

                // Get the prime factorization of the cycle length

                if (cycleLength > 1) {

                    getPrimeFactors(cycleLength, maxPrimePowers);

                }

            }

        }

        

        // Calculate the LCM modulo 10^9 + 7

        long ans = 1;

        for (Map.Entry<Integer, Integer> entry : maxPrimePowers.entrySet()) {

            int prime = entry.getKey();

            int power = entry.getValue();

            long primePowerVal = powerMod(prime, power, MOD);

            ans = (ans * primePowerVal) % MOD;

        }

        

        return (int) ans;

    }

    

    // Updates the map with the highest powers of prime factors of a number

    private static void getPrimeFactors(int num, Map<Integer, Integer> maxPrimePowers) {

        int temp = num;

        for (int i = 2; i * i <= temp; i++) {

            if (temp % i == 0) {

                int count = 0;

                while (temp % i == 0) {

                    count++;

                    temp /= i;

                }

                maxPrimePowers.put(i, Math.max(maxPrimePowers.getOrDefault(i, 0), count));

            }

        }

        if (temp > 1) {

            maxPrimePowers.put(temp, Math.max(maxPrimePowers.getOrDefault(temp, 0), 1));

        }

    }

    

    // Modular Exponentiation: (base^exp) % mod

    private static long powerMod(long base, long exp, long mod) {

        long res = 1;

        base = base % mod;

        while (exp > 0) {

            if ((exp & 1) == 1) {

                res = (res * base) % mod;

            }

            base = (base * base) % mod;

            exp >>= 1;

        }

        return res;

    }

 

}