class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        // dist[i][j] = minimum number of upward moves needed
        // to reach (i,j) for a given number of downward moves.
        //
        // Instead, use the key observation:
        // For any cell (i,j), the net vertical displacement is i-r.
        // If downward moves = x, then upward moves = x + (r-i).
        //
        // So we only need to minimize downward moves to reach each cell.
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // 0-1 BFS:
        // left/right = cost 0
        // down = cost 1
        // up = cost 0
        //
        // We minimize the number of DOWN moves.
        java.util.ArrayDeque<int[]> dq = new java.util.ArrayDeque<>();

        dist[r][c] = 0;
        dq.addFirst(new int[]{r, c});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dr[k];
                int ny = y + dc[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (mat[nx][ny] == '#') {
                    continue;
                }

                int cost = (nx > x) ? 1 : 0;

                if (dist[x][y] + cost < dist[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + cost;

                    if (cost == 0) {
                        dq.addFirst(new int[]{nx, ny});
                    } else {
                        dq.addLast(new int[]{nx, ny});
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '#') {
                    continue;
                }

                if (dist[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                // If minimum downward moves is 'downMoves',
                // then upward moves required are:
                //
                // upMoves = downMoves + (r - i)
                //
                // because:
                // finalRow = r + downMoves - upMoves
                // i = r + downMoves - upMoves
                // upMoves = downMoves + r - i

                int downMoves = dist[i][j];
                int upMoves = downMoves + r - i;

                if (downMoves <= d && upMoves <= u) {
                    ans++;
                }
            }
        }

        return ans;
    }
}

