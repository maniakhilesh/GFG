class Solution {
    public int maxProduct(int n) {
        
        // // using DP
        
        // int[] memo = new int[n +1];
        // Arrays.fill(memo, -1);
        // return recur(n, memo);
        
        
        // // using greedy + maths
        
        // return solve(n);
        
        // // using binary or fast exponentiation
        
        if (n == 2 || n == 3) return n -1;
        
        int cnt3 = n / 3;
        int rem  = n % 3;
        
        if (rem == 1) {
            cnt3 -= 1;
            rem = 4;
        }
        
        int prd = power(3, cnt3);
        if (rem == 2 || rem == 4) prd *= rem;
        
        return prd;
    }
    
    private int recur(int n, int[] memo) {
        if (n == 1) return 1;
        if (memo[n] != -1) return memo[n];
        
        int res = 0;
        for (int i=1; i<=n/2; i++) {
            res = Math.max(
                res, Math.max(i * (n -i), i * recur(n -i, memo))    
            );
        }
        return memo[n] = res;
    }
    
    private int solve(int n) {
        if (n == 2 || n == 3)
            return n -1;
            
        int prd = 1;
        while (n > 4) {
            prd *= 3;
            n -= 3;
        }
        
        return prd * n;
    }
    
    private int power(int base, int exp) {
        int res = 1;
        
        while (exp > 0) {
            if ((exp & 1) != 0) {
                res *= base;
            }
            base *= base;
            exp >>= 1;
        }
        return res;
    }
}