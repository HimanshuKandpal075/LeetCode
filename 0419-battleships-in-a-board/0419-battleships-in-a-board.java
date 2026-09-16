class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean vis[][] = new boolean[n][m];

        int count = 0;

        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == 'X' && !vis[i][j]){
                    count++;
                    helper(board, i, j, vis);
                }
            }
        }
        return count;
    }

    static void helper(char[][] board, int r, int c, boolean[][] vis){
        int n = board.length;
        int m = board[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        vis[r][c] = true;
        for(int i=0;i<4;i++){
            int nR = r + dr[i];
            int nC = c + dc[i];

            if(nR >= 0 && nR < n &&
                nC >= 0 && nC < m &&
                board[nR][nC] == 'X' && 
                !vis[nR][nC]){
                    helper(board, nR, nC, vis);
                }
        }
    }
}