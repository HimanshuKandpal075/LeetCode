class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    count ++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }

    static void helper(char[][] grid, int r, int c){
        int n = grid.length;
        int m = grid[0].length;

        if(r < 0 || r >= n ||
            c < 0 || c >= m ||
            grid[r][c] == '0'){
                return;
            }

        grid[r][c] = '0';

        helper(grid, r+1, c);
        helper(grid, r-1, c);
        helper(grid, r, c+1);
        helper(grid, r, c-1);

    }
}