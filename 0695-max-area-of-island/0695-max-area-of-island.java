class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];

        int max = 0;
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count = helper(grid, i, j, vis);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    static int helper(int[][] grid, int r, int c, boolean vis[][]){
        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        vis[r][c] = true;
        int count = 1;

        for(int i=0;i<4;i++){
            int nR = r + dr[i];
            int nC = c + dc[i];

            if(nR >= 0 && nR < n && 
                nC >= 0 && nC < m &&
                grid[nR][nC] == 1 && 
                !vis[nR][nC]){
                    count += helper(grid, nR, nC, vis);
                }
        }
        return count;
    }
}