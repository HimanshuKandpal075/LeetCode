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

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        vis[r][c] = true;

        for(int i=0;i<4;i++){
            int nR = r + dr[i];
            int nC = c + dc[i];

            if(nR >= 0 && nR < n &&
                nC >= 0 && nC < m &&
                board[nR][nC] == 'O' &&
                !vis[nR][nC]){
                    helper(board, nR, nC, vis);
            }
        }
    }
}