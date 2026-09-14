class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            if(grid[i][0] == 1 ){
                helper(grid, i, 0);
            }
            if(grid[i][m-1] == 1  ){
                helper(grid, i, m-1);
            }
        }

        for(int j=0;j<m;j++){
            if(grid[0][j] == 1  ){
                helper(grid, 0, j);
            }
            if(grid[n-1][j] == 1  ){
                helper(grid, n-1, j);
            }
        }

        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    static void helper(int[][] grid, int r, int c){
        int n = grid.length;
        int m = grid[0].length;

        if(r < 0 || r >= n ||
            c < 0 || c >= m ||
            grid[r][c] == 0 ){
                return;
        }

        grid[r][c] = 0;

        helper(grid, r-1, c);
        helper(grid, r+1, c);
        helper(grid, r, c-1);
        helper(grid, r, c+1);
    }
}