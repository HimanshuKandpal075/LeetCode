class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean vis[][] = new boolean[n][m];


        for(int j=0;j<m;j++){
            if(board[0][j] == 'O' && !vis[0][j]){
                helper(board, 0, j, vis);
            }

            if(board[n-1][j] == 'O' && !vis[n-1][j]){
                helper(board, n-1, j, vis);
            }
        }

        for(int i=0;i<n;i++){
            if(board[i][0] == 'O' && !vis[i][0]){
                helper(board, i, 0, vis);
            }

            if(board[i][m-1] == 'O' && !vis[i][m-1]){
                helper(board, i, m-1, vis);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    static void helper(char[][] board, int r, int c, boolean[][] vis){
        int n = board.length;
        int m = board[0].length;

        if(r < 0 || r >= n ||
            c < 0 || c >= m ||
            board[r][c] == 'X' ||
            vis[r][c]){
                return;
            }

        vis[r][c] = true;

        helper(board, r+1, c, vis);
        helper(board, r-1, c, vis);
        helper(board, r, c+1, vis);
        helper(board, r, c-1, vis);
    }
}