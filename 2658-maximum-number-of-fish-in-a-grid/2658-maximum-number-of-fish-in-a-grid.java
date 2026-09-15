class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] > 0){
                    int sum = dfs(grid, i, j);
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    static int dfs(int[][] grid, int r, int c){
        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int sum = grid[r][c];
        grid[r][c] = 0;

        for(int i=0;i<4;i++){
            int nR = r + dr[i];
            int nC = c + dc[i];

            if(nR >= 0 && nR < n && 
                nC >= 0 && nC < m &&
                grid[nR][nC] != 0){
                    sum += dfs(grid, nR, nC);
                }
        }
        return sum;
    }
}