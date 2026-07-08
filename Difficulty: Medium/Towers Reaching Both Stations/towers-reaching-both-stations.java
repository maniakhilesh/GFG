class Solution {
    public void dfs(int row , int col , int[][] mat , int[][] visitCnt , boolean[][] visited , int n , int m){
        
        visited[row][col] = true;
        visitCnt[row][col]++;
        
        int[][] neighbors = {{row - 1 , col},{row , col + 1},{row + 1 , col},{row , col - 1}};
        
        for(int[] neigh : neighbors){
            int nr = neigh[0];
            int nc = neigh[1];
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                if(!visited[nr][nc] && mat[nr][nc] >= mat[row][col]){
                    dfs(nr , nc , mat , visitCnt , visited , n , m);
                }
            }
        }
    }
    public int countCoordinates(int[][] mat) {
        // code here
        
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        int[][] visitCnt = new int[n][m];
        
        //from P
        for(int j = 0 ; j < m ; j++){
            if(!visited[0][j]){
                dfs(0 , j , mat , visitCnt , visited , n , m);
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(!visited[i][0]){
                dfs(i , 0 , mat , visitCnt , visited ,n , m);
            }
        }
        visited = new boolean[n][m];
        //from Q
        for(int i = 0 ; i < n ; i++){
            if(!visited[i][m-1]){
                dfs(i , m - 1 , mat , visitCnt , visited, n , m);
            }
        }
        for(int j = 0 ; j < m ; j++){
            if(!visited[n-1][j]){
                dfs(n - 1 , j , mat , visitCnt , visited, n , m);
            }
        }
        
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(visitCnt[i][j] > 1){
                    ans++;
                }
            }
        }
        return ans;
    }
}

