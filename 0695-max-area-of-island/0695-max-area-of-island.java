class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int max = 0;
        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    count = helper(grid, i, j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    static int helper(int[][] grid, int r, int c){
        int n = grid.length;
        int m = grid[0].length;

        if(r < 0 || r >= n || 
                c < 0 || c >= m ||
                grid[r][c] == 0 ){
                    return 0;
        }
        else{
            grid[r][c] = 0;
            return 1 + helper(grid, r+1, c) +
                helper(grid, r-1, c)+
                helper(grid, r, c+1)+
                helper(grid, r, c-1);
        }
    }
}