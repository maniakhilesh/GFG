class Solution {
    // Memoization
    public int maxDotProductMemo(int i, int j, int diff, int[] a, int[] b, int[][] dp) {
        //  Base Case
        if(i >= a.length || j >= b.length) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        // Skipping or multiplying with zero
        int exclude = 0;
        
        if(i - j < diff) {
            exclude = maxDotProductMemo(i+1, j, diff, a, b, dp);
        }
        
        // Adding to dot product
        int include = (a[i] * b[j]) + maxDotProductMemo(i+1, j+1, diff, a, b, dp);
        
        return dp[i][j] = Math.max(include, exclude);
    }
    
    // Tabulation
    public int maxDotProductTab(int[] a, int[] b) {
        int sizeA = a.length;
        int sizeB = b.length;
        int diff = sizeA - sizeB;
        int[][] dp = new int[sizeA+1][sizeB+1];
        
        for(int i = sizeA-1; i >= 0; i--) {
            for(int j = sizeB-1; j >= 0; j--) {
                // Skipping or multiplying with zero
                int exclude = 0;
                
                if(i - j < diff) {
                    exclude = dp[i+1][j];
                }
                
                // Adding to dot product
                int include = (a[i] * b[j]) + dp[i+1][j+1];
                
                dp[i][j] = Math.max(include, exclude);
            }
        }
        
        return dp[0][0];
    }
    
    // Tabulation SO
    public int maxDotProductTabSO(int[] a, int[] b) {
        int sizeA = a.length;
        int sizeB = b.length;
        int diff = sizeA - sizeB;
        int[] next = new int [sizeB+1];
        
        for(int i = sizeA-1; i >= 0; i--) {
            int[] curr = new int [sizeB+1];
            
            for(int j = sizeB-1; j >= 0; j--) {
                // Skipping or multiplying with zero
                int exclude = 0;
                
                if(i - j < diff) {
                    exclude = next[j];
                }
                
                // Adding to dot product
                int include = (a[i] * b[j]) + next[j+1];
                
                curr[j] = Math.max(include, exclude);
            }
            
            // Updation
            next = curr;
        }
        
        return next[0];
    }
    
    public int maxDotProduct(int[] a, int[] b) {
        // Memoization
        // int sizeA = a.length;
        // int sizeB = b.length;
        // int diff = sizeA - sizeB;
        // int[][] dp = new int[sizeA][sizeB];
        
        // // Filling with -1
        // for(int[] arr: dp) {
        //     Arrays.fill(arr, -1);
        // }
        
        // return maxDotProductMemo(0, 0, diff, a, b, dp);
        
        // Tabulation
        return maxDotProductTab(a, b);
        
        // Tabulation SO
        // return maxDotProductTabSO(a, b);
    }
}