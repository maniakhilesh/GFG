class Solution {
    Integer[][] dp;
    
    public int solve(int arrLen , int n , int m , int prevEle){
        if(arrLen == n){
            return 1;
        }
        if(dp[arrLen][prevEle] != null){
            return dp[arrLen][prevEle];
        }
        int cnt = 0;
        for(int i = 1 ; i <= m ; i++){
            if((i % prevEle == 0) || (prevEle % i == 0)){
                cnt += solve(arrLen + 1 , n , m , i);
            }
        }
        return dp[arrLen][prevEle] = cnt;
    }
    public int count(int n, int m) {
        // code here
        dp = new Integer[n+1][m+1];
        return solve(0 , n , m , 1);
    }
}

