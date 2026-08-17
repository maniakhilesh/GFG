class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        // code here
        HashMap<Integer,Integer> ladd=new HashMap<>();
        HashMap<Integer,Integer> snake=new HashMap<>();
        for(int i=0;i<lad.length;i+=2){
            ladd.put(lad[i],lad[i+1]);
        }
        for(int i=0;i<sn.length;i+=2){
            snake.put(sn[i],sn[i+1]);
        }

        int dp[]=new int[n*n+2];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=0;


        Queue<Integer>q=new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()){
            int curr=q.remove();

            for(int mv=1;mv<7;mv++){
                int nj=curr+mv;
                if(nj>n*n) continue;
                if(ladd.containsKey(nj)){
                    nj=ladd.get(nj);
                }else if(snake.containsKey(nj)) nj=snake.get(nj);

                if(dp[nj]>dp[curr]+1){
                    dp[nj]=dp[curr]+1;
                    q.add(nj);
                }

            }
        }
        return dp[n*n]==Integer.MAX_VALUE ? -1 : dp[n*n];
    }
}