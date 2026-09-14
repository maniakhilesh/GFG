class Solution {

    static class Node{
        int row;
        int col;
        int steps;
        Node(int row , int col , int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    int shortestPath(int[][] mat) {
        // code here

        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    int[][] neighs = {{i-1,j},{i,j+1},{i+1,j},{i,j-1}};
                    for(int[] nei : neighs){
                       int r = nei[0];
                       int c = nei[1];
                       if(r >= 0 && r < n && c >= 0 && c < m){
                           visited[r][c] = true;
                       }
                    }
                }

            }
        }


        Queue<Node> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(mat[i][0] == 1 && !visited[i][0]){
                q.offer(new Node(i , 0 , 1));
                visited[i][0] = true;
            }
        }
        int minSteps = Integer.MAX_VALUE;

        while(!q.isEmpty()){

            int sz = q.size();
            while(sz-- > 0){
                Node curr = q.poll();
                int row = curr.row;
                int col = curr.col;
                int steps = curr.steps;
                int[][] neighs = {{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
                for(int[] nei : neighs){
                    int r = nei[0];
                    int c = nei[1];
                    if(r >= 0 && r < n && c >= 0 && c < m && !visited[r][c] && mat[r][c] != 0){
                        if(c == m-1){
                            return steps+1;
                        }

                        q.offer(new Node(r , c , steps+1));
                        visited[r][c] = true;
                    }
                }
            }
        }
        return -1;
    }
}